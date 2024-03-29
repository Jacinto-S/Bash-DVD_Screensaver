![Demo Header](https://raw.githubusercontent.com/Jacinto-S/Bash-DVD_Screensaver/main/Feature%20showcase/demo.gif)

# Bash-DVD_Screensaver
The traditional DVD Screensaver, but for bash.


# Installation
You have two options:
1. Download the .jar file provided.
2. Build it yourself using Maven

The resulting .jar file can be run with java -jar (filepath)

### Dependencies
- Linux as your OS
- OpenJDK 20 or above (examplary Fedora installation: https://docs.fedoraproject.org/en-US/quick-docs/installing-java/)
- Maven 3.8 or above

### Use it as a screensaver for your terminal
You can run this like a screensaver using tmux.
To do so, add the following config to your ~/.tmux.conf file:
```conf
set-option -g lock-after-time 120 # duration before screensaver activates in seconds
set-option -g lock-command "java -jar /home/me/programms/Bash-DVD_Screensaver.jar" # replace this with your path
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
Check your specific distributions' options for this. On Fedora, for example, you can configure your terminal via \<right-click> -> preferences -> <Profiles +> -> Command -> \<Check "Run a custom command instead of my shell"> -> \<Set Custom Command to: /usr/bin/tmux>

# Features
- The program self-adjusts when changing the window size <br />
<img src="https://raw.githubusercontent.com/Jacinto-S/Bash-DVD_Screensaver/main/Feature%20showcase/resize-showcase.gif" width="530" height="192"> <br />
- Screensaver starts after inactivity in your bash (if set up) <br />
<img src="https://github.com/Jacinto-S/Bash-DVD_Screensaver/blob/main/Feature%20showcase/autostart.gif" width="530" height="243"> <br />
- Settings
- Logo bouncing off of corners <br />
- Logo changing color

# Configuration
The program will automatically create a configuration file on its first launch.
You can use it to adjust movement speed & direction, set the colors to bright or dark only and have the background of the DVD Icon colored instead of the font color.

Find the file at:
```bash
~/.config/bash-dvd-screensaver/config.properties
```
You now have the following options: <br /><br />
**Movement Speed:** The lower this number is, the faster the icon will move.<br />
```bash
movementSpeed:48  
```
**Movement Direction:** (x/y) -> x is the horizontal, y the vertical direction for each movement.<br />
```bash
movementDirection:(2/1)
```
**Color Background:** true or false<br />
```bash
colorBackground:false
```
**Colorscheme:** 0 = bright, 1 = dark, 2 = random <br />
```bash
colorscheme:0
```

# Usage
The screensaver will start automatically when executing the Java file. 
**To stop the application and have your bash's text color reset, press enter.**


# Planned
- Settings
- Build script

# Credit
DVD icon source: https://copypastatext.com/dvd-logo/
