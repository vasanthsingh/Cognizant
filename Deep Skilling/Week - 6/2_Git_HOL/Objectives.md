
## 1.Explain `.gitignore`

- **Purpose**:  
  `.gitignore` is a file in which you list files or directories that Git should ignore and not track in version control.
  
- **Example**:
  ```gitignore
  # Ignore build files
  /build/

  # Ignore system files
  Thumbs.db
  .DS_Store

  # Ignore logs
  *.log
  ```

---

## 2. How to Ignore Unwanted Files Using `.gitignore`

1. Create a `.gitignore` file in your project root.
2. Add patterns for files/folders you want to ignore.
3. Save the file.
4. If the files were already tracked, remove them from tracking:
   ```bash
   git rm --cached filename
   ```
5. Commit the `.gitignore` file:
   ```bash
   git add .gitignore
   git commit -m "Added .gitignore to ignore unwanted files"
   ```

