import os
import re

REPO_URL = os.getenv("GITHUB_REPOSITORY", "")

def parse_directories():
    problems = []
    pattern = re.compile(r"^0*(\d+)-(.*)$")

    for item in sorted(os.listdir(".")):
        if os.path.isdir(item) and not item.startswith("."):
            match = pattern.match(item)
            if match:
                prob_id = int(match.group(1))
                slug = match.group(2)
                title = slug.replace("-", " ").title()
                
                # Check for solution files inside the folder
                folder_path = item
                files = os.listdir(folder_path)
                solution_file = next((f for f in files if not f.endswith(".md")), None)
                solution_path = f"{item}/{solution_file}" if solution_file else item
                
                problems.append({
                    "id": prob_id,
                    "title": title,
                    "folder": item,
                    "link": solution_path
                })
    return problems

def build_markdown(problems):
    lines = [
        "# 🚀 LeetCode Solutions Archive",
        "",
        "> Automated LeetCode archive synchronized via [LeetSync](https://github.com/LeetCode-Sync/LeetSync).",
        "",
        "## 📊 Progress",
        "",
        f"- **Total Solved:** {len(problems)}",
        "",
        "---",
        "",
        "## 📂 Problems List",
        "",
        "| # | Problem Title | Solution |",
        "| :---: | :--- | :---: |"
    ]

    for p in sorted(problems, key=lambda x: x["id"]):
        lines.append(f"| {p['id']} | [{p['title']}](./{p['folder']}) | [Code](./{p['link']}) |")

    lines.append("")
    return "\n".join(lines)

def main():
    problems = parse_directories()
    markdown_content = build_markdown(problems)
    with open("README.md", "w", encoding="utf-8") as f:
        f.write(markdown_content)
    print(f"Successfully generated README.md with {len(problems)} problems.")

if __name__ == "__main__":
    main()

    name: Update LeetCode README

on:
  push:
    branches:
      - main
    paths-ignore:
      - 'README.md'

permissions:
  contents: write

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout Repository
        uses: actions/checkout@v4
        with:
          fetch-depth: 0

      - name: Set up Python
        uses: actions/setup-python@v5
        with:
          python-version: '3.x'

      - name: Generate README
        run: python generate_readme.py

      - name: Commit and Push Changes
        run: |
          git config --global user.name "github-actions[bot]"
          git config --global user.email "41898282+github-actions[bot]@users.noreply.github.com"
          git add README.md
          if git diff --staged --quiet; then
            echo "No changes detected in README.md"
          else
            git commit -m "docs: auto-update LeetCode solutions index [skip ci]"
            git push
          fi
