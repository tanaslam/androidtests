#This script displays current directory in cyan and git current branch in green on
#shell prompt.
#The script should reside in user home
function git-branch-name {
  git symbolic-ref HEAD 2>/dev/null | cut -d"/" -f 3
}
function git-branch-prompt {
  local branch=`git-branch-name`
  if [ $branch ]; then printf " [%s]" $branch; fi
}
PS1="\u@\h \[\033[0;36m\]\W\[\033[0m\]\[\033[0;32m\]\$(git-branch-prompt)\[\033[0m\] \$ " 

#Runs git command complete script
if [ -f ~/.git-completion.bash ]; then
  . ~/.git-completion.bash
fi
