# NameCheckerV2

This Java program allows you to check the availability of Minecraft In-Game Names (IGN) from a list of words in a text file.

## Features

- Read a list of words from a text file.
- Check the availability of each word as a Minecraft IGN.
- Display the results, indicating whether each word is available or not.
- Collect and display available IGNs.

## Getting Started

1. [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) version 17 or above is required to run
the Discord Bot Online Tool.

2. Go to [Release Page](https://github.com/RTX4O9O/NameCheckerV2/releases) and download the `name-check.zip` from latest release 

3. Unzip `name-check.zip` then run the `run.bat` 

4. Key the file path of your word list into the cmd. (make sure the file contains one word per line like this)
```txt
ign1
ign2
ign3
ign4
```

5. The program will start checking the availability of each word.

6. The results will be displayed in the console, showing whether each word is available or not.

7. The available IGNs will be listed separately once process is over.

## How It Works

The program uses the Mojang API to check the availability of each word as a Minecraft IGN. It sends HTTP GET requests to the API and checks the response code. If the response code is `HTTP_NOT_FOUND`, the word is considered available; otherwise, it's not available.

## Example

```
[CHECK]  word1
[CROSS]  word2
[CHECK]  word3
...

Available IGNs:
word1
word3
```

## Contributions
Feel free to contribute to this project by improving the code, adding new features, or suggesting enhancements. You can submit pull requests or open issues to discuss changes.
