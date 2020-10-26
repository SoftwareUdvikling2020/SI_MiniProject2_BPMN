# System Integration Mini Project BPMN
| Magnus Klitmose            |  Rasmus Lynge               | Mathias Kristensen |
| :-------------:            |  :-------------:            | :-------------: |
| cph-mk525@cphbusiness.dk   | cph-rj173@cphbusiness.dk  | cph-mk523@cphbusiness.dk |

## Business Case
Our project will be used by travel agencies or perhaps travel insurance companies. 
It is based on the danish Ministry of Foreign Affairs' travel guidelines, and more specifically the color classification for countries, 
which indicate whether traveling to a country for leisure purposes is advisable.

For now, the program takes a 'countrycolor' as an input, and based on that it decides whether a certain trip or perhaps travel insurance can be approved. 
* if red, it is always **not** approved
* if green, it is always approved
* if yellow, it requires human approval through a confirmation

## Running this project:
- Clone the project
- Start your local Camunda  
- Go to the src/main/recources and find the travelBooking.bpmn file. This file needs to be deployed on Camunda (You can use the camunda modeller for deployment, like in the class example)  
- Run the main method with Intelij.
- Start a task in local Camunda with a country color of red, yellow or green.

In the current iteration of the model, the confirmation is given by claiming the task, and adding an 'approved' variable as a boolean in the form. 


