import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		int clickId=-1;
		for(int i=0;i<buttons.length;i++)
		{
			if(buttons[i]==buttonClicked)
			{
				clickId=i;
			}
		}
		if(Math.abs(clickId-emptyCellId)==1)
		{
		swapButton(buttons[emptyCellId],buttonClicked);
		emptyCellId=clickId;
		}
		else if(clickId+4==emptyCellId || clickId-4==emptyCellId)
		{
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId=clickId;
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		ArrayList<Integer>  l = new ArrayList<Integer>();
		for(int i=1;i<=15;i++)
		{
			l.add(i);
		}
		Collections.shuffle(l);
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=l.get(i);
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		int arr[]=getIntegerArrayOfButtonIds(buttons);
		int num=1;
		for(int i=0;i<arr.length;i++)
		{
			if(num==arr[i])
			{
				num++;
			}
			else
			{
				winner=false;
				break;
			}
		}
		return winner;
	}
}