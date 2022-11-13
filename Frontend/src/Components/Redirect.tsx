import { useEffect } from "react";

export const Redirect: React.FC<Props> = ({ url }: Props) => {
  useEffect(() => {
    window.location.href = url ?? "";
  });
  return <></>;
};

interface Props {
  url?: string;
}
