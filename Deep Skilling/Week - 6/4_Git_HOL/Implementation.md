# Verify if master is clean and create a new branch
```mkdir MergeConflictDemo
cd MergeConflictDemo
git init
git status
git checkout -b GitWork
echo "Hello from GitWork branch" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in GitWork branch"
```
# Update hello.xml
```echo "Updated content from GitWork branch" > hello.xml
git add hello.xml
git commit -m "Updated hello.xml in GitWork branch"
```
# switch to master branch and add a different hello.xml
```git checkout master
echo "Hello from master branch" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in master branch"
```
# view branch history and compare changes
```git log --oneline --graph --decorate --all
git diff master GitWork
```
# Conflict
```git merge GitWork //the merge will raise conflict

git config --global diff.tool p4merge
git config --global difftool.p4merge.cmd '"C:/Program Files/Perforce/p4merge.exe" "$LOCAL" "$REMOTE"'
git merge GitWork //thisThe 3-way merge window will open:
//Left → Your current branch (master)
//Right → Incoming branch (GitWork)
//Base → Common ancestor
//Choose what you want from each side (or manually edit).

git add hello.xml
git commit -m "Resolved merge conflict in hello.xml"


# Add backup files to .gitignore
echo "*.orig" >> .gitignore
git add .gitignore
git commit -m "Added .gitignore to ignore backup files"

# Delete new branch and view final log
git branch -d GitWork
git log --oneline --graph --decorate
```











