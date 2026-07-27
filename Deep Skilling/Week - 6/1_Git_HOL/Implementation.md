# Configuring git
```bash
git --version
git config --global user.name "Name" 
git config --global user.email "Email@example.com"
git config --list
```
# Setting up notepad++
```notepad++
git config --global core.editor "notepad++ -multiInst -notabbar -nosession -noPlugin"
```
# Setting up Repository 
```mkdir GitDemo
cd GitDemo
git init
echo "Welcome to Git Hands-On Lab" > welcome.txt
git status
git add welcome.txt
git commit
git remote add origin https://gitlab.com/week4461132/GitDemo.git
# git branch -m main
git pull -u origin master
git push -u origin master
```
