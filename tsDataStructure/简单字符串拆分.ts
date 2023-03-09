/* eslint-disable @typescript-eslint/no-unused-vars */

// 简单的文件拆分函数
// 问题是字符串中含有emoji，emoji是几个字符存储（5个？）
// 使用grapheme-splitter库
function lineBreak(text: string, lineLength: number): string[] {
  const lines: string[] = []

  while (text.length > lineLength) {
    lines.push(text.substr(0, lineLength))
    text = text.substr(lineLength)
  }

  lines.push(text)
  return lines
}
