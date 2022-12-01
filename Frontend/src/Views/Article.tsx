import React, { useEffect, useState } from "react";
import parse from "html-react-parser";
import { Button, TextField } from "@mui/material";
import { marked } from "marked";
import * as DOMPurify from "dompurify";
import { useSnackbar } from "notistack";

import axios, { AxiosResponse } from "axios";
import { IArticle } from "../Types";

export const Article: React.FC = () => {
  const [articleName, setArticleName] = useState<string>();
  const [markdown, setMarkdown] = useState("**Hello, world!**");
  const [html, setHtml] = useState<string | JSX.Element | JSX.Element[]>();
  const { enqueueSnackbar } = useSnackbar();

  const htmlStringDirty = `<html><body>
  <button.onclick="alert(String.fromCharCode(60,115,99,114,105,112,116,62,97,108,
  101,114,116,40,34,67,114,111,115,115,83,105,116,101,83,99,114,105,112,116,105,1
  10,103,64,82,69,77,79,86,69,34,41,60,47,115,99,114,105,112,116,62));">String:fr
  om.Char.Code</button></body></html>`;

  useEffect(() => {
    const loadDataAsync = async () => {
      const urlTailIndex = window.location.pathname.lastIndexOf("/");
      const tempName = window.location.pathname.substring(urlTailIndex + 1);

      /* const { data }: AxiosResponse<IArticle> = await axios.get(
        `/articles/name?name=${tempName}`
      );*/

      const { data } = await axios.get(`/articles/name?name=${tempName}`);

      console.log(data);
      if (data === undefined || data === "") return;

      document.title = `${tempName} - Futurepedia`;
      setMarkdown(data.Content);
      setArticleName(tempName);
    };

    loadDataAsync();
  }, []);

  useEffect(() => {
    const htmlDirty = marked.parse(markdown); //htmlStringDirty - use htmlStringDirty to test the sanitization
    const htmlSanitized = DOMPurify.sanitize(htmlDirty);

    try {
      // .. To improve this code, I might only show detailed errors when the project is in dev mode via
      // process.env.NODE_ENV
      // .. perhaps I would have a custom error that I could throw and catch below to display a specific message
      if (htmlDirty !== htmlSanitized) throw Error(`Sanitization failed`);

      setHtml(parse(htmlSanitized));
    } catch (e) {
      enqueueSnackbar(`Sanitization failed`, {
        variant: "error",
      });
      console.error(htmlDirty);
      console.error(htmlSanitized);
      console.error(e);
    }
  }, [markdown]);

  const saveArticle = async () => {
    try {
      // .. make axios PUT request (awaited) to update the article on the database
      /* const { data } = await axios.put("/articles", {});

      if (data < 1)
        throw Error(`Expected one or more rows to be updated, got 0`); */

      enqueueSnackbar(`Saved successfully`, {
        variant: "success",
      });
    } catch (e) {
      enqueueSnackbar(`Save error`, {
        variant: "error",
      });
      console.error(e);
    }
  };

  return (
    <>
      <h1>Article m8</h1>
      <TextField
        fullWidth
        multiline
        rows={20}
        value={markdown}
        onChange={({ target: { value } }) => setMarkdown(value)}
        variant="standard"
        style={{ background: "#EEEEEE", margin: 20, padding: 10 }}
      />
      <TextField
        fullWidth
        multiline
        value={marked.parse(markdown)}
        variant="standard"
        style={{ background: "#EEEEEE", margin: 20, padding: 10 }}
        disabled
      />

      {html}
      <Button variant="contained" color="primary" onClick={saveArticle}>
        Save
      </Button>
    </>
  );
};
