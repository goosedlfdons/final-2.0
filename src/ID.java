

public enum ID {

    //only one player, one tower, and one smart enemy so far

    Player(),

    Teammate(),

    //ID tag for old basic enemy that only bounces off walls
    //better enemy = AiEnemy that actively follows player or the tower
    Enemy(),

    Tower(),

    Trail(),

    Weapon(),

    AiEnemy();


}
