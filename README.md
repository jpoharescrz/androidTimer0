# androidTimer1
Simple demo of timed events using Handlers in android
Implements and demos a periodivc event using Handler() and
Runnable() where the handler executes the runnable code which
implement the counter and modifies the button text.
This program has a Start/Stop button and counter TextView
to display the current count.
- Program initializes to a count of zero and Start/Stop button text
set to 'Start'. 
- Pressing "Start" initiates the counting (1 sec) by
posting (handler 'post' member) the runnable code to the handler and 
changing the button text to "Stop". 
- The runnable code function increments the counter and changes the 
counter TextView to reflect this. It also re-schedules itself to 
be called in 1 second using the postDelayed member of the handler.
- Pressing the "Stop" terminates the periodic running of the runnable code 
function by calling the 'removeCallbacks' member of the handler.
