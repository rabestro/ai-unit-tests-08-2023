# ai-unit-tests-08-2023

A Comparative Analysis of AI-Based Unit Test Generation Tools for Java Applications.

## Introduction

The purpose of this repository is to compare the results of various programs for generating unit tests. The programs are:
- [DiffBlue]
- [ChatGPT-4]
- Microsoft [CopilotX]
- JetBrains [AI Assistant]
- [Machinet]
- [Symflower]

## Logging of sessions

| Test Date    | Prompt ID | Class / Method         | Comments                                                           |
|--------------|-----------|------------------------|--------------------------------------------------------------------|
| [2023-08-20] | WhiteBox  | RomanToArabicConverter | AI suggested adding missing validation for roman numerals.         |
| [2023-08-21] | WhiteBox  | isSameTree             | AI did not follow instructions for adding messages for assertions. |
| [2023-08-22] | BlackBox  | inorderTraversal       | well-chosen test cases                                             |

[2023-08-20]: https://jc-ai.notion.site/2023-08-20-Prompt-Test-40600a79f26a4f2999b446fafd193afa

[2023-08-21]: https://jc-ai.notion.site/2023-08-21-Prompt-test-60943975a44749b89ab24276ecbb7e78

[2023-08-22]: https://jc-ai.notion.site/2023-08-22-BlackBox-Unit-Test-e424abaeeea94a6b940b4c9d66aa7cea

[DiffBlue]: https://www.diffblue.com/
[Machinet]: https://www.machinet.net/
[CopilotX]: https://github.com/features/preview/copilot-x
[AI Assistant]: https://blog.jetbrains.com/idea/2023/06/ai-assistant-in-jetbrains-ides/
[Symflower]: https://symflower.com/en/
[ChatGPT-4]: https://openai.com/gpt-4
