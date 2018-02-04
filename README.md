# AVeryResponsibleApp2.0 (Udacity Google Development Challenge Scholarship 2017)
Layout changes for readability, and added one more activity (soberness quiz). TODO: added activity's java needs some fixing.

Changes to previous version (AVeryResponsibleApp):
Layout:
- it uses a different measurement for strong and weak alcohol (dl vs cl);
- the RESET button received a larger font;
- the displayed text was slightly changed (simplified) (e.g., ”lvl” was deleted);
- a completely different background image for both sides (alcohol and water);
- changed text colours and text sizes for both the unit counters and the alcohol & water text views;
- moved a lot of the layout.xml into styles and referenced them from there.

Java:
- a new activity was added (wrapped in ScrollView so that no separate layout-land is needed), making the app multiscreen: after the alcohol units reach 15, a quiz page pops up and begins to test user on their basic math;
- after 5 calculations, app calculates soberness (correctness) score, and if it reaches 3 or more out of 5, it displays a positive toast, if not, it displays a toast saying ”Go home friend, you’re drunk!”

TODO: the java is not perfect yet.
- Now user has to press the submit Quiz button more than once to get the next calculation displayed.
- The mid-quiz toasts (wrong/correct notifications) misbehave sometimes (correctness notification appears when shouldn't).
- Next: after fixing these, the plan is to send the sober enough user back to mainActivity.java so that they can continue drinking.
The drunk user might get brought to a new activity displaying a skull or something (I could even do this within the quiz activity by changing what appears on the screen).
