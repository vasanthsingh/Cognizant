
# Setting up Repository 
```mkdir GitIgnoreDemo
cd GitIgnoreDemo
git init
```
# creating .log file to ignore, with other files
```echo "This is a sample log file" > sample.log
echo "test for GitIgnoreDemo" > Test.md
mkdir log
echo "inside log folder" > log/error.log
```

# creating .gitignore
```bash
touch .gitignore
# Inside .gitignore, add:
*.log
log/
```


# commit and checking status
```git add .
git commit -m "ignoring log folder and .log files"
git status
```