Please limit the use of AI-generated code. AI is fine for brainstorming or minor debugging, but PRs that are entirely slop will not be accepted.

Only submit code that meaningfully improves the calculator. We don't need multiple functions that do the same thing.

When adding a new function, make it as capable as possible, and give it clear navigation to related functions. For example: the Scientific Calculator should have a button linking to the 2D and 3D graphers, and each grapher should have a button back to the Scientific Calculator (and to each other, if relevant).

Be mindful of memory usage and time complexity. Don't introduce something like O(n^n) unless it's absolutely necessary, if it is, explain why in the PR description.

Before opening a PR, verify that your code works correctly, including common edge cases (empty input, division by zero, overflow, invalid characters, etc.).
