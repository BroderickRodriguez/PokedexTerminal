public class Pokemon {
    private String pokeName;
    private String pokeType;
    private int pokeAtk;
    private int pokeHp;

    public Pokemon(String pokeName, String pokeType, int pokeAtk, int pokeHp) {
        this.pokeName = pokeName;
        this.pokeType = pokeType;
        this.pokeAtk = pokeAtk;
        this.pokeHp = pokeHp;
    }

    public String getPokeName() {
        return pokeName;
    }

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }

    public String getPokeType() {
        return pokeType;
    }

    public void setPokeType(String pokeType) {
        this.pokeType = pokeType;
    }

    public int getPokeAtk() {
        return pokeAtk;
    }

    public void setPokeAtk(int pokeAtk) {
        this.pokeAtk = pokeAtk;
    }

    public int getPokeHp() {
        return pokeHp;
    }

    public void setPokeHp(int pokeHp) {
        this.pokeHp = pokeHp;
    }
}
