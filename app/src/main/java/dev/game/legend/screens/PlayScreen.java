package dev.game.legend.screens;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.KeyEvent;
import dev.game.legend.Enemy;
import dev.game.legend.Player;
import dev.game.legend.Screen;
import dev.game.legend.State;
import dev.game.legend.data.CharInfo;
import dev.game.legend.data.Position;
import dev.game.legend.data.Stage;
import dev.game.legend.R;

public class PlayScreen extends Screen {
	
	private long endTime;
	Stage stage;
	Player player;
	Enemy enemy;
	int timer = 100;
	int score;
	RectF pLine = new RectF(0, 20, 100, 40);
	RectF eLine = new RectF(0, 20, 100, 40);
	Paint lPaint = new Paint();
	Paint tPaint= new Paint();
	int lastResult = -1;
	private Bitmap hud;
	private Bitmap commandUnknown;
	private Bitmap commandRock;
	private Bitmap commandScissor;
	private Bitmap commandPaper;
	private int counter;
	String text;
	int mainState=State.S_PLAY;
	int stageNr;

	public PlayScreen(Context c) {
		super(c);
		Resources res = mContext.getResources();
		commandUnknown = BitmapFactory.decodeResource(res, R.drawable.command_unknown);
		commandRock = BitmapFactory.decodeResource(res, R.drawable.command_rock);
		commandScissor = BitmapFactory.decodeResource(res, R.drawable.command_scissor);
		commandPaper = BitmapFactory.decodeResource(res, R.drawable.command_paper);
		hud = BitmapFactory.decodeResource(res, R.drawable.top);
		this.tPaint = new Paint();
		tPaint = new Paint();
		tPaint.setAntiAlias(true);
		tPaint.setShadowLayer(5, 0, 0, 0xFF000000);
	}

	@Override
	public boolean action(int key, KeyEvent c) {
		if( state == State.G_THREE||state == State.G_TWEE|| state == State.G_ONE)
			player.setCommand(c.getAction() - 49);
		return true;
	}

	@Override
	public void action(int x, int y) {
		if( state == State.G_THREE||state == State.G_TWEE|| state == State.G_ONE)
			player.setCommand(x / 100);
	}

	@Override
	public int stateMachine() {
		if (counter < 2) {
			counter++;
			return mainState;
		}
		counter=0;
		switch (state) {
		case State.G_START:
			onStart();
			break;
		case State.G_THREE:
			onThree();
			break;
		case State.G_TWEE:
			onTwo();
			break;
		case State.G_ONE:
			onOne();
			break;
		case State.G_FIGHT:
			onFight();
			break;
		case State.G_DECIDE:
			onDecide();
			break;
		case State.G_CELEBRATE:
			onCelebrate();
			break;
		case State.G_FINISH:
			onFinish();
			break;
		default:
			onStart();
			break;
		}
		return mainState;
	}

	private void onFinish() {
		if( player.info.health>enemy.info.health){
			player.info.state=CharInfo.STATE_LEVELING;
			enemy.info.state=CharInfo.STATE_DYING;
			text = "Stage "+stageNr+" cleared";
			if(stageNr<3)
			state=mainState= State.S_TRANSITION;
			else
				state=mainState= State.S_END;
				
		}else{
			player.info.state=CharInfo.STATE_DYING;
			enemy.info.state=CharInfo.STATE_LEVELING;
			text = mContext.getResources().getString(R.string.message_finish_lose);
			state=mainState= State.S_GAMEOVER;
		}

	}

	private void onCelebrate() {
		if (lastResult == State.R_LOSING) {// lose
			player.info.state = CharInfo.STATE_LOSSING;
			enemy.info.state = CharInfo.STATE_WINNING;
			text = "";
		} else if (lastResult == State.R_WINNING) {// win
			player.info.state = CharInfo.STATE_WINNING;
			enemy.info.state = CharInfo.STATE_LOSSING;
			player.info.score+=score;
			text = "";

		} else {
			player.info.state = CharInfo.STATE_DRAWING;
			enemy.info.state = CharInfo.STATE_DRAWING;
			text = "";
		}
		lastResult=State.R_UKNOWN;
		player.setCommand(-1);
		enemy.setCommand(-1);
		if (player.info.health > 0 && enemy.info.health > 0 &&(System.currentTimeMillis()<endTime) )
			state= State.G_THREE;
		else
			state= State.G_FINISH;
	}

	private void onDecide() {
		if(lastResult==State.R_UKNOWN)
			lastResult = decide(player.info.command, enemy.info.command);
			switch (lastResult) {
			case 1://player win
				text = mContext.getResources().getString(R.string.message_win);
				if(player.info.magic<100)
					player.info.magic += 7;
				if (enemy.info.health > 0)
					enemy.info.health -= 10;
				break;
			case -1://player lose
				text = mContext.getResources().getString(R.string.message_lose);
				if(enemy.info.magic<100)
					enemy.info.magic += 7;
				if (player.info.health > 0)
					player.info.health -= 10;
				break;
			default:
				text = mContext.getResources().getString(R.string.message_draw);
				player.info.magic += 3;
				enemy.info.magic += 3;
				break;
			}
		state= State.G_CELEBRATE;
	}

	private void onFight() {
		player.info.state = CharInfo.STATE_SHOWING;
		enemy.info.state = CharInfo.STATE_SHOWING;
		state= State.G_DECIDE;
	}

	private void onOne() {
		text = mContext.getResources().getString(R.string.message_count_down_1);
		if(enemy.info.command==CharInfo.COMMAND_UNKNOWN) 
			enemy.generateCommand();

		state= State.G_FIGHT;
	}

	private void onTwo() {
		player.info.state = CharInfo.STATE_IDLE;
		enemy.info.state = CharInfo.STATE_IDLE;
		text = mContext.getResources().getString(R.string.message_count_down_2);
		state= State.G_ONE;
	}

	private void onThree() {
		player.info.state = CharInfo.STATE_NONE;
		enemy.info.state = CharInfo.STATE_NONE;
		text = mContext.getResources().getString(R.string.message_count_down_3);
		state= State.G_TWEE;
	}

	private void onStart() {
		player.info.state = CharInfo.STATE_NONE;
		enemy.info.state = CharInfo.STATE_NONE;
		text = "Stage "+stageNr+" start";
		state= State.G_THREE;
	}
	public void drawTime(Canvas g) {

	}

	int decide(int playerCommand, int enemyCommand) {
		int res = enemyCommand - playerCommand;
		if (playerCommand <0){
			return State.R_LOSING;
		}
		if ( res == -1 || res == 2) {// draw
			score=100;
			return State.R_LOSING;
		} else if (res == 1 || res == -2) {// win
			score+=100;
			return State.R_WINNING;
		} else {
			if(score>100)score-=50;
			return State.R_DRAWING;
		}
	}

	public CharInfo getEnemy() {
		return enemy.info;
	}

	public Player getPlayer() {
		return player;
	}

	public void init(CharInfo p, int currentStage) {
		counter = 0;
		state = State.G_START;
		mainState=State.S_PLAY;
		lastResult=State.R_UKNOWN;
		this.endTime = System.currentTimeMillis() + 200000;
		p.health=100;
		setPlayer(p);
		stageNr=currentStage;
		setStage(currentStage);
		setEnemy(stage.enemy);
		image = stage.image;
		score=100;
		text="";
	}

	private void setStage(int currentStage) {
		stage=new Stage(mContext, currentStage);
	}

	@Override
	public void paintScreen(Canvas g) {
		g.drawBitmap(image, 0, 0, null);
		drawPlayers(g);
		drawHud(g);
		drawTime(g);
		drawText(g);
		drawCommands(g);
	}
	public void drawHud(Canvas g) {
		g.drawBitmap(hud,0,0,lPaint);
		player.icon.draw(g);
		enemy.icon.draw(g);
		//g.drawBitmap(BitmapFactory.decodeResource(mContext.getResources(),player.),2,20,tPaint);
		//g.drawBitmap(BitmapFactory.decodeResource(mContext.getResources(),R.drawable.basic_icon), 292, 20, tPaint);
		lPaint.setAntiAlias(true);
		lPaint.setStyle(Style.FILL);
		lPaint.setARGB(255, 255, 0, 0);
		lPaint.setStrokeWidth(2);

		// healthbar
		pLine.set(30, 20, 130, 40);
		eLine.set(190, 20, 290, 40);
		g.drawRoundRect(pLine, Position.CURVE, Position.CURVE, lPaint);
		g.drawRoundRect(eLine, Position.CURVE, Position.CURVE, lPaint);


		lPaint.setColor(0xFFFFFF00);
		lPaint.setStyle(Style.FILL);
		
		pLine.right = player.info.health+30;
		g.drawRoundRect(pLine, Position.CURVE, Position.CURVE, lPaint);
		eLine.left = 290 - enemy.info.health;
		g.drawRoundRect(eLine, Position.CURVE, Position.CURVE, lPaint);

		
		pLine.right= 130;
		eLine.left= 190;
		lPaint.setColor(0xFFFFFF);
		lPaint.setStyle(Style.STROKE);
		lPaint.setShadowLayer(3, 2, 2, 0xFF000000);
		g.drawRoundRect(pLine, Position.CURVE, Position.CURVE, lPaint);
		g.drawRoundRect(eLine, Position.CURVE, Position.CURVE, lPaint);

		tPaint.setColor(0xFFFFFFFF);
		tPaint.setTextSize(16);
		tPaint.setTextAlign(Align.LEFT);
		g.drawText(player.info.name, 32, 51, tPaint);
		g.drawText(Position.SCORE + player.info.score, Position.SPAN+ Position.ICON_SIZE, Position.SCOREY, tPaint);
		tPaint.setTextAlign(Align.RIGHT);
		g.drawText(enemy.info.name, 248, 51, tPaint);

		tPaint.setTextAlign(Align.CENTER);
		g.drawText("Time", 160, Position.TIMEY, tPaint);
		tPaint.setTextSize(48);
		int x = (int) ((endTime - System.currentTimeMillis()) / 1000);
		if (x < 0) x = 0;
		tPaint.setTextSize(40);
		g.drawText("" + x,160, Position.TIME1Y, tPaint);
		tPaint.setTextSize(48);

	}

	private void drawPlayers(Canvas g) {
		player.paint(g);
		enemy.paint(g);
	}
	private void drawCommands(Canvas g) {
		switch(player.info.command){
		case CharInfo.COMMAND_UNKNOWN:
			g.drawBitmap(commandUnknown, 0, 400,tPaint);
			break;
		case CharInfo.COMMAND_ROCK:
			g.drawBitmap(commandRock, 0, 400,tPaint);
			break;
		case CharInfo.COMMAND_SCISSOR:
			g.drawBitmap(commandScissor, 0, 400,tPaint);
			break;
		case CharInfo.COMMAND_PAPER:
			g.drawBitmap(commandPaper, 0, 400,tPaint);
			break;
		}

	}
	private void drawText(Canvas g) {
		g.drawText(text, 160, 200, tPaint);
	}
	public void setEnemy(CharInfo e) {
		enemy = new Enemy(mContext, e);
	}
	public void setPlayer(CharInfo p) {
		player = new Player(mContext, p);

	}
	public void setPlayer(Player p) {
		player = p;
	}
	public void setEnemy(Enemy e) {
		enemy = e;
	}

	public Stage getStage() {
		return stage;
	}
}
