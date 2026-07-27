
## 1. Branching and Merging

- **Branching**:  
  A branch is an independent line of development. You can create a branch to work on a new feature without affecting the main codebase.
  ```bash
  git branch feature-branch
  git checkout feature-branch
  ```
  Or:
  ```bash
  git checkout -b feature-branch
  ```

- **Merging**:  
  Merging combines changes from one branch into another.
  ```bash
  git checkout main
  git merge feature-branch
  ```
  If no conflicts, Git merges automatically; otherwise, you must resolve conflicts manually.

---

## 2. Creating a Branch in GitLab

1. Go to your GitLab project.
2. Navigate to **Repository → Branches**.
3. Click **New branch**.
4. Enter branch name and select the branch to create from (usually `main`).
5. Click **Create branch**.

---

## 3. Creating a Merge Request in GitLab

1. Push your local branch to GitLab:
   ```bash
   git push origin feature-branch
   ```
2. In GitLab, navigate to **Merge Requests**.
3. Click **New merge request**.
4. Select **source branch** (your feature branch) and **target branch** (e.g., `main`).
5. Add a title, description, and reviewers.
6. Click **Submit merge request**.



