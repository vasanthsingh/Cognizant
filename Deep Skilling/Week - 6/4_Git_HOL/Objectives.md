
## 1. Resolving Merge Conflicts

Merge conflicts occur when Git cannot automatically merge changes from different branches because the same part of the same file has been edited differently.  

**Steps to Resolve:**
1. **Identify the conflict** – Git will mark conflicts in the file using:
   ```text
   <<<<<<< HEAD
   Your changes
   =======
   Incoming branch changes
   >>>>>>> branch-name
   ```
2. **Manually edit** the file to keep the correct code or merge both changes.
3. **Mark the conflict as resolved**:
   ```bash
   git add filename
   ```
4. **Complete the merge**:
   ```bash
   git commit
   ```