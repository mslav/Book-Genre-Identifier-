Before running, place the data files within the "Data" folder under the project file, the sample files are
already there.
To run this program simply go inside this project file within the terminal (.../GenreIdentifier/) and run:

java -jar GenreIdentifier.jar file1.json file2.csv

where file1.json and file2.csv are the two data files that the program parses. I have already included the
sample files provided so you may already run for instance:

java -jar GenreIdentifier.jar booking.json keywords.csv




In order to print the genres in order (if they aren't given in order), I decided to use a TreeMap which was an
interesting learning process. I have also decided to store the genre score for each book as a double as I realized
if the total number of points of found keywords was not divisible by the number of found keywords, then the score would
not be as accurate. An edge case I ran into was realizing that printing any genre scores of 0 is not neccessary so I
simply did not store those.
