Image selected_price_1 = Image.load("zero_with_point");
Image selected_price_2 = Image.load("one_with_zero");

int stickCount = 2;
int stickSize = 52;

var priceL = Point.get(1750, 547);
var priceR = Point.get(1890, 618);

var viewExit = Point.get(304, 951);

var error = Point.get(1357, 752);
int errorColor = 9992742;

var stickL = Point.get(1473,581);
var stickR = Point.get(1473 + (5 - stickCount) * stickSize,602); 

var buy = Point.get(2240,569);

var confirm = Point.get(1197,748);

var upd = Point.get(1002,463);

int slotH = 144;

int slotA = 3;

int updColor = 6381138;

startScreenCapture(2);
setMinMatchQuality(97); 
sleep(5);
long kdtime = Time.getMillis();

long slpS = 1000;
int itt = 0;

Point lp = Point.get();    
Point rp = Point.get(); 
long secItter = 0;
for (;;)
{ 
    for(int q = 0; q < slotA; q++)
    {
        lp.x = stickL.x;
        lp.y = stickL.y + (q * slotH);
        rp.x = stickR.x;
        rp.y = stickR.y + (q * slotH);
        if (hasImg(selected_price_1, priceL, priceR) || hasImg(selected_price_2, priceL, priceR))
        {
            click(buy.x, buy.y);  
            sleep(25);
            clickRand(confirm, 0);
            sleep(350);
            if (getColor(error.x, error.y) <= errorColor + 1000)
            {
                clickRand(confirm, 0);
                sleep(120);
                log("error buy › "+Time.getTime());
            }
            else
                log("buy › "+Time.getTime());
            click(viewExit.x, viewExit.y); 
        }
        if (getContoursCount (lp, rp) > 1 && getColor(buy.x, buy.y + (slotH * q)) < 11077777)
        {
            click(buy.x, buy.y + (slotH * q));  
            sleep(25);
            clickRand(confirm, 0);
            sleep(350);
            if (getColor(error.x, error.y) <= errorColor + 1000)
            {
                clickRand(confirm, 0);
                sleep(120);
                log("error buy › "+Time.getTime());
            }
            else
                log("buy › "+Time.getTime());
            click(viewExit.x, viewExit.y); 
        }
        if ((((Time.getMillis() - kdtime) / slpS) != secItter) && getColor(buy.x, buy.y + (slotH * q)) > 14000000)
        {
            secItter = ((Time.getMillis() - kdtime) / slpS);
            sleep(100);
            clickRand(upd, 0);
            sleep(100);
            clickRand(upd, 0);
            sleep(300);
            click(viewExit.x, viewExit.y); 
            break;
        }
        if (getColor(upd.x, upd.y) < 10000000)
        {
            sleep(100);
            clickRand(upd, 0);
            log("upd bug › "+Time.getTime());
            click(viewExit.x, viewExit.y); 
        }
    }
}
