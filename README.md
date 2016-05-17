# Calculator
Uppsala Universitet P2 - Lab4 *** Abandoned project, see --> CalculatorFX ***

Swing is so painful and produce very confusing and odd results so you really fight to control it. It is the reason why Java programs look awful. As my great teachers saw what I was trying to do they said I was beyond the lab and they let me move on to use JavaFX instead and I was commited. That strong MVC environment and workflow is a true blessing for Java. JavaFX introduce major changes in how to deal with a GUI and I found great use of this wonderful tutorial: http://code.makery.ch/library/javafx-8-tutorial/

<p><b>
CController.java
</b><br>
The controller.

<p><b>
CGFXModel.java
</b><br>
Model that load the graphics package, convert that to icons and store those in as ImageIcons in an array.
Load the normal- and the advanced background images and also prepare them as ImageIcons so they are ready for the CViewer as Swing components.
The model also compose all buttons with ImageIcons so they are ready for the Viewer. There are getter methods for everything in the Controller.

<p><b>
CViewer.java
</b><br>
Viewer for the calculator. Has the action listeners and action handlers today, but the handlers will be moved to the Controller later.

<p><b>
CBrain.java
</b><br>
The smart little brain of the Calculator (that compute math problems).
It is using recursive descent but as the GUI is not ready for it yet I wait with upload and implementation.

<p><b>
Icn.java
</b><br>
Enumeration index for matching icons and buttons with array-indexes. It is in line with the text file that is the in-data to produce the graphics package so this file should never be changed, just extended.
