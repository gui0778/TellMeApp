//encode 'utf-8'
var col = 10;
var row = 10;
var SnackList = new Array;
var GoDir = "→"//方向
var speed = 100; //速度
var timergo;
var x;
var y;
var integral = 0;
function Start() {
    $("#show").html("");
    integral = 0;
    $("#dintegral").html("积分:0");
    SnackList = new Array();
    clearInterval(timergo);
    for (var i = 0; i < row; i++) {//布局
        for (var j = 0; j < col; j++) {

            $("#show").append("<span col='" + j + "' row='" + i + "' ></span>");
        }
    }

    LoadSnack(); //初始加载食物
    xy(0, 49); //生成随机食物
    $(document).keyup(function (event) {
        switch (event.which) {
            case 37: //左
                if (GoDir != "→") {
                    GoDir = "←";
                }
                break;
            case 38: //上
                if (GoDir != "↓") {
                    GoDir = "↑";
                }
                break;
            case 39: //右
                if (GoDir != "←") {
                    GoDir = "→";
                }
                break;
            case 40: //下
                if (GoDir != "↑") {
                    GoDir = "↓";
                }
                break;
            default:

        }
    });
    timergo = setInterval(function () {
        var gox = SnackList[0].row;
        var goy = SnackList[0].col;
        switch (GoDir) {
            case "←": //左
                if ((parseInt(SnackList[0].col, 10) - 1) >= 0) {
                    SnackList[0].col = parseInt(SnackList[0].col, 10) - 1;
                } else {
                    alert("游戏结束撞到左面");
                    clearInterval(timergo);
                    return;
                }
                break;
            case "↑": //上
                if ((parseInt(SnackList[0].row, 10) - 1) >= 0) {
                    SnackList[0].row = parseInt(SnackList[0].row, 10) - 1;
                } else {
                    alert("游戏结束撞到上面");
                    clearInterval(timergo);
                    return;
                }
                break;
            case "→": //右
                if ((parseInt(SnackList[0].col, 10) + 1) < 50) {
                    SnackList[0].col = parseInt(SnackList[0].col, 10) + 1;
                } else {
                    alert("游戏结束撞到右面");
                    clearInterval(timergo);
                    return;
                }
                break;
            case "↓": //下

                if ((parseInt(SnackList[0].row, 10) + 1) < 50) {
                    SnackList[0].row = parseInt(SnackList[0].row, 10) + 1;
                } else {
                    alert("游戏结束撞到下面");
                    clearInterval(timergo);
                    return;
                }
                break;
            default:
        } //行走

        $("#show [row='" + gox + "'][col='" + goy + "']").removeClass("select");
        $("#show [row='" + SnackList[0].row + "'][col='" + SnackList[0].col + "']").removeClass("select").addClass("select");
        for (var i = 1; i < SnackList.length; i++) {
            var nextx = SnackList[i].row;
            var nexty = SnackList[i].col;
            SnackList[i].row = gox;
            SnackList[i].col = goy;
            $("#show [row='" + nextx + "'][col='" + nexty + "']").removeClass("select");
            $("#show [row='" + SnackList[i].row + "'][col='" + SnackList[i].col + "']").removeClass("select").addClass("select");
            if (SnackList[0].row == SnackList[i].row && SnackList[0].col == SnackList[i].col) {
                alert("游戏结束咬到了自己");
                clearInterval(timergo);
                return;
            }
            gox = nextx;
            goy = nexty;
        }
        //是否吃到食物
        if (SnackList[0].row == x && SnackList[0].col == y) {
            var Snacks = new Array();
            Snacks["row"] = gox;
            Snacks["col"] = goy;
            SnackList.push(Snacks);
            xy(0, 49); //生成新食物
            integral++;
            $("#dintegral").html("积分:" + integral);
        }
    }, speed);
}

function LoadSnack() {
    for (var i = 25; i >= 20; i--) {
        $("#show [row='24'][col='" + i + "']").removeClass("select").addClass("select");
        var Snacks = new Array();
        Snacks["row"] = 24;
        Snacks["col"] = i;
        SnackList.push(Snacks);
        
    } 
}
var xy = function (min, max) {
    var RetNum = "";
    var IsOk = true;
    while (IsOk) {
        x = Math.floor(min + Math.random() * (max - min));
        y = Math.floor(min + Math.random() * (max - min));
        RetNum = "[row='" + x + "'][col='" + y + "']";
        if ($("#show " + RetNum).hasClass("select")) {
            if ($("#show .select").length == $("#show").children().length) {
                IsOk = false;
                RetNum = "NO";
            }
        } else {
            IsOk = false;
        }
    }
    if (RetNum == "NO") {
        alert("挑战成功");
    } else {
        $("#show " + RetNum).removeClass("select").addClass("select");
    }
}