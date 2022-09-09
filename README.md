# Android Project 1 - *Wordle*

Submitted by: **Joshua Rechkemmer**

**Wordle** is an android app that recreates a simple version of the popular word game [Wordle](https://www.nytimes.com/games/wordle/index.html). 

Time spent: **3** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **User has 3 chances to guess a random 4 letter word**
- [x] **After 3 guesses, user should no longer be able to submit another guess**
- [x] **After each guess, user sees the "correctness" of the guess**
- [x] **After all guesses are taken, user can see the target word displayed**

The following **optional** features are implemented:

- [ ] User can toggle betweeen different word lists
- [ ] User can see the 'correctness' of their guess through colors on the word 
- [ ] User sees a visual change after guessing the correct word
- [x] User can tap a 'Reset' button to get a new word and clear previous guesses
- [x] User will get an error message if they input an invalid guess
- [ ] User can see a 'streak' record of how many words they've guessed correctly.

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

* Win Condition 
<img src='https://github.com/Reckhammer/Wordle/blob/master/gifs/WordleWin.gif' title='App Walkthrough' width='' alt='Video Walkthrough' />

* Lose Condition 
<img src='https://github.com/Reckhammer/Wordle/blob/master/gifs/WordleLose.gif'/>

* Restarting Game 
<img src='https://github.com/Reckhammer/Wordle/blob/master/gifs/WordleRestart.gif'/>

<!-- Replace this with whatever GIF tool you used! -->
GIF created with [ScreenToGif](https://www.screentogif.com/) for Windows
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS

[peek](https://github.com/phw/peek) for Linux. -->

## Notes

I had some trouble getting the keyboard to stop pushing the layout upwards making the textviews off screen while typing a guess. I found a solution on this [Stack Overflow Post](https://stackoverflow.com/questions/4207880/android-how-do-i-prevent-the-soft-keyboard-from-pushing-my-view-up), but it cuts off some parts of the text still.

## License

    Copyright 2022 Joshua Rechkemmer

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
