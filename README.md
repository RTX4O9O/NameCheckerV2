# NameCheckerV2

This Java program allows you to check the availability of Minecraft In-Game Names (IGN) from a list of words in a text file.

## Features

- Read a list of words from a text file.
- Check the availability of each word as a Minecraft IGN.
- Display the results, indicating whether each word is available or not.
- Collect and display available IGNs.

## Getting Started

1. Clone this repository to your local machine.

2. Open the project in your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse).

3. Run the `Main` class.

4. You will be prompted to enter the file path for the list of words. Make sure the file contains one word per line.

5. The program will start checking the availability of each word.

6. The results will be displayed in the console, showing whether each word is available or not.

7. The available IGNs will be listed separately.

## How It Works

The program uses the Mojang API to check the availability of each word as a Minecraft IGN. It sends HTTP GET requests to the API and checks the response code. If the response code is `HTTP_NOT_FOUND`, the word is considered available; otherwise, it's not available.

## Example

```
[✅] ign1
[❌] ign2
[✅] ign3
...

Available IGNs:
ign1
ign3
```

## Contributions
Feel free to contribute to this project by improving the code, adding new features, or suggesting enhancements. You can submit pull requests or open issues to discuss changes.
