import React, { useState } from "react";
import parse from "html-react-parser";
import { TextField } from "@mui/material";
import { marked } from "marked";

export const Article: React.FC = () => {
  const [markdown, setMarkdown] = useState("**Hello, world!**");

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
      {parse(marked.parse(markdown))}
    </>
  );
};
