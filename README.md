# README #

### What is this repository for? ###

Part A of the Coursework1 for Big Data Processing module

### How do I get set up? ###

Create a Histogram plot that depicts the distribution of tweet sizes (measured in number of characters) among the 
Twitter dataset. To make the data more readable, the histogram must aggregate bars in groups of 5 (that is, first bar 
counts tweets of length 1-5, second bar counts tweets 6-10, and so on) as part of your MapReduce job. Your MapReduce 
program must compute the histogram bins for a correct solution. Aggregating bins outside MapReduce will deduct marks 
from the complete grade.
Note 1: For considering the size of a message you should simply refer to the length() of the String provided as input.

Note 2: There are numerous tweets written in foreign languages, which contain characters with non-standard encoding that might cause some unexpected (i.e. too high) values. This is a common occurrence when dealing with real data. We recommend you filter out all the messages with a length longer than 140 characters. You can also handle them differently if you prefer so and provide an appropriate explanation.  The report has to explain the approach you took, and the reasoning behind it
