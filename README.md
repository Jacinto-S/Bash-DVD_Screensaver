![image](https://github.com/Jacinto-S/Bash-DVD_Screensaver/assets/122536229/a36de062-446c-470c-b2b5-e38dc474bc42)

# Bash-DVD_Screensaver
The traditional DVD Screensaver but for bash.


# Installation
To run this, build it using Maven (e.g. Lifecycle -> install in IntelliJ).
The resulting .jar file can be run with java -jar filename.

### Use as screensaver for your terminal
You can run this like a screensaver using tmux.
To do so, add the following config to your ~/.conf.tmux file:
```conf
set-option -g lock-after-time 120 # duration before screensaver activates in seconds
set-option -g lock-command "java -jar /home/me/programms/Bash-DVD_Screensaver.jar" # Replace with your path
set-option -g visual-silence off
set-option -g silence-action
set-option -g visual-bell off
```
Update tmux by entering
```bash
tmux source ~/.tmux.conf
```
In a tmux window, your terminal will now activate this after your specified amount of seconds of inactivity.

### Setup your terminal to automatically open as a tmux window
Check your specific distributions' options for this. For example, on Fedora, you can set by setting your terminal via \<right-click> -> preferences -> <Profiles +> -> Command -> \<Check "Run a custom command instead of my shell"> -> \<Set Custom Command to: /usr/bin/tmux>

# Usage
The screensaver will start automatically when executing the java file. 
**To stop the application and have your bash's text-colour reset, press enter.**

# Features
- Program Self-Adjusts when changing Window Size
- Logo bouncing of corners
- Logo changing color
- Screensaver activating after inactivity in your bash (If activated)


# Planned
- Make this automatically run from bash after inactivity.
- Settings

# Credit
DVD icon source: [https://www.twitchqoutes.com/copypaste/4211](https://www.twitchquotes.com/copypastas/4211)https://www.twitchquotes.com/copypastas/4211
