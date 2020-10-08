# Project1
This documentation should contain understanding of the problem and your problem-solving approach, description of methods and variables used. This file will be reviewed by an instructor along with the codes during code review.
1. Objective:

  In order to complete the task, I broke HammingDist into a constructor with an additional three classes. I created lots of class variables to store the values that would go into the different information that had to be determined. 
  The first class I made found the hamming distance between each of the code inputs and Norman. By going through each character of the code in a for loop and comparing them in an if statement, I was able to add up the amount of characters that differed in each code at a particular spot. This method then returned the hamming distance.
  The second class that I created was to read the Mesonet file. In case the file was not found, I made sure to include a throws statement for an IOException. In this method, I created a file and a BufferedReader to read through the file for Mesonet. I used a for loop to skip over the first title lines of the file and then created a String variale code. I created a while loop so that the method would stop reading at the end of the file. If the readLine came back as null, this would cause the loop to break, and end the reading of the file. From each line of the file, I took out the specific substring with the code and then added it to the codes array.


### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system



