
# configuring p4Merge tool after downloading it
```git config --global diff.tool p4merge
git config --global difftool.p4merge.path "C:\\Program Files\\Perforce\\p4merge.exe"

git config --global merge.tool p4merge
git config --global mergetool.p4merge.path "C:\\Program Files\\Perforce\\p4merge.exe"
```
# commit the master branch
```echo "Hello Git" > hello.txt
git add hello.txt
git commit -m "Initial commit on GitNewBranch"
git branch -a
```

# Create a new branch and switch
```git checkout -b GitNewBranch
echo "This is a test file for GitNewBranch" > branchfile.txt
git add branchfile.txt
git commit -m "Added a file in GitNewBranch"
git branch -a
git status
```

# Merging
```git checkout master
git diff master GitNewBranch
git difftool master GitNewBranch
git merge GitNewBranch
git log --oneline --graph --decorate
git branch -d GitNewBranch
git status
```