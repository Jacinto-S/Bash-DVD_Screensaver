# Bash-DVD_Screensaver
The traditional dvd screensaver but for bash.

This is one of my first projects. Playing around with Ansii sequences, I wanted to make something that uses the color-changing features.
To run this properly, change the xmax and ymax values to your bash size. You can get that value with tput:
ymax = tput lines
xmax = tput cols

To run the file in your terminal use:
"javac TextAnimation.java" to compile to bytecode at first use.
"java TextAnimation" to run.

Planned:
- Make this automatically run from bash.
- Add a config file with the tput lines and tput cols so users don't have to input it manually.
