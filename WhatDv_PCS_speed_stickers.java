int stickCount = 2;
int stickSize = 52;

var viewExit = Point.get(304, 951);

var error = Point.get(1357, 752);
int errorColor = 9992742;

var stickL = Point.get(1473,581);
var stickR = Point.get(1473 + (5 - stickCount) * stickSize,602); 
var stickL2 = Point.get(1473,581 + 144);
var stickR2 = Point.get(1473 + (5 - stickCount) * stickSize,602 + 144); 

var buy = Point.get(2240,569);

var confirm = Point.get(1197,748);

var upd = Point.get(1002,463);

int slotH = 144;

int slotA = 3;

int updColor = 6381138;

startScreenCapture(2);
sleep(5);
long kdtime = Time.getMillis();
long bufTime = 0;
long slpS = 1500;
long secItter = 0;
int updErrorFlag = 0;
for (;;)
{ 
        if (getContoursCount (stickL, stickR) > 2 && getColor(buy.x, buy.y) < 11077777)
        {
                click(buy.x, buy.y);  
                sleep(17);
                clickRand(confirm, 0);
                sleep(500);
                log("try buy 1› "+Time.getTime());
                click(viewExit.x, viewExit.y); 
                sleep(50);
        }
        if (getContoursCount (stickL2, stickR2) > 2 && getColor(buy.x, buy.y + 144) < 11077777)
        {
                click(buy.x, buy.y + 144);  
                sleep(17);
                clickRand(confirm, 0);
                sleep(500);
                log("try buy 2› "+Time.getTime());
                click(viewExit.x, viewExit.y); 
                sleep(50);
        }
        if (getColor(error.x, error.y) < 11077777)
        {
                clickRand(confirm, 0);
                sleep(50);
                log("error buy 1› "+Time.getTime());
                click(viewExit.x, viewExit.y); 
                sleep(50);
        }
        bufTime = (Time.getMillis() - kdtime) / slpS;
        if (bufTime != secItter && (getColor(buy.x, buy.y) > 14000000 || bufTime % 8 == 0))
        {
            secItter = bufTime;
            sleep(50);
            clickRand(upd, 0);
            sleep(50);
            clickRand(upd, 0);
            sleep(50);
            if (bufTime != secItter && getColor(upd.x, upd.y) < 10000000)
            {
                    secItter = bufTime;
                    sleep(50);
                    clickRand(upd, 0);
                    log("upd bug › "+Time.getTime());
            }
            click(viewExit.x, viewExit.y); 
            sleep(50);
        }
}
