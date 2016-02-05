# RomanToDecimalConversion

A short project with simple classes for conversion of Roman numbers to Decimal numbers.

Program execution instruction:

1) Open the command line (in Windows) or a shell (in Linux) and open the parent folder for the code downloaded from the repository. It's the folder which contains subfolders named 'src' and 'lib'. By default it's named 'RomanToDecimalConversion-master' (if you download the repository in ZIP format directly from this website) or 'RomanToDecimalConversion' (if you clone repository to your computer using Git).

2) Compile the sources and build the project using the following command:

  Windows: **mkdir bin & javac -d bin -cp ./lib/\*.jar ./src/pl/wiktorfryze/conversion/\*.java**

  Linux: **mkdir bin ; javac -d bin -cp ./lib/\*.jar ./src/pl/wiktorfryze/conversion/\*.java**

3) Run the program using the following command:

  Windows: **java -cp ./bin;./lib/ pl.wiktorfryze.conversion.CodeRunner {argument}**

  Linux: **java -cp ./bin:./lib/ pl.wiktorfryze.conversion.CodeRunner {argument}**

where {argument} is the input in Roman Numerical format you want to convert to its decimal representation for example

  Windows: **java -cp ./bin;./lib/ pl.wiktorfryze.conversion.CodeRunner XVII**

  Linux: **java -cp ./bin:./lib/ pl.wiktorfryze.conversion.CodeRunner XVII**

4) Execute all the unit tests for the project using the following command:

  Windows: **java -cp ./bin;./lib/junit-4.10.jar pl.wiktorfryze.conversion.TestsRunner**

  Linux: **java -cp ./bin:./lib/junit-4.10.jar pl.wiktorfryze.conversion.TestsRunner**
