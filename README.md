# Project1

  In order to complete the task, I broke HammingDist into a constructor with an additional three methods. I created lots of class variables to store the values that would go into the different information that had to be determined. I did this so that I could use the constructor to call on the other methods in Hammingdist, and assign all of the values. AFter assigning all of the values, I made string statements with the lines to be printed. The constructor then proceeds to print the lines.
  
  The first method I made found the hamming distance between each of the code inputs and Norman. By going through each character of the code in a for loop and comparing them in an if statement, I was able to add up the amount of characters that differed in each code at a particular spot. This method then returned the hamming distance.
 
 The second method that I created was to read the Mesonet file. In case the file was not found, I made sure to include a throws statement for an IOException. In this method, I created a file and a BufferedReader to read through the file for Mesonet. I used a for loop to skip over the first title lines of the file and then created a String variable code. I created a while loop so that the method would stop reading at the end of the file. If the readLine came back as null, this would cause the loop to break, and end the reading of the file. From each line of the file, I took out the specific substring with the code and then added it to the codes array.
  
  The third method found the number of codes in the Mesonet file with the same Hamming distance as with the Norman code. I started this method by calling on the readFile method if it had not already been called in order to create the ArrayList of codes. From there, I used a for loop to go through each code in the ArrayList and compare it to the String place. I used another for loop to go through each character of each String and compared that with the character in the same index of the String place. If they were different, it was added into the value count. If the count for each String in codes was equal to the hamming distance value for the Norman string, it was summed into the value mathcing, which was then returned.

For the methods in the DataTimeOne class, I first used DateTimeFormatter to create the format for the date. Then, I used LocalDateTime.now to get the current date. This was then turned into a String in the format created in the beginning of the method. Finally, the code printed out the information in the correct form.

For the getValeOfSecond method, I once again used LocalDateTime.now to get the current date. From there, I used the .getSecond method to assign the second value to an int. This was then returned by the method.

For sleepForThreeSec(), TimeUnit is used to make the program wait/sleep for 3 seconds.

I have created and attached my UML documentation. I could not figure out how to underline the words for static classes, my apologies.
