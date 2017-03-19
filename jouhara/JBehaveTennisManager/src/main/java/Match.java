public class Match {
    private Player player1;

    private Player player2;

    private Umpire umpire;

    private String court;

    public Match() {
    }

    public Match(Player player1, Player player2, Umpire umpire, String court) {
        this.player1 = player1;
        this.player2 = player2;
        this.umpire = umpire;
        this.court = court;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Umpire getUmpire() {
        return umpire;
    }

    public void setUmpire(Umpire umpire) {
        this.umpire = umpire;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }
}
