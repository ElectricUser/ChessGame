package utils;
import dataStructures.BiMap;
import static java.util.Map.entry;

public class Utils {
    public BiMap<String, String> positions = BiMap.<String, String>ofEntries(entry("a8", "00"), entry("b8", "01"), entry("c8",
            "02"), entry("d8", "03"), entry("e8", "04"), entry("f8", "05"), entry("g8", "06"),
            entry("h8", "07"), entry("a7", "10"), entry("b7", "11"), entry("c7", "12"),
            entry("d7", "13"), entry("e7", "14"), entry("f7", "15"), entry("g7", "16"), entry("h7", "17"),
            entry("a6", "20"), entry("b6", "21"), entry("c6", "22"), entry("d6", "23"), entry("e6", "24"),
            entry("f6", "25"), entry("g6", "26"), entry("h6", "27"), entry("a5", "30"), entry("b5", "31"),
            entry("c5", "32"), entry("d5", "33"), entry("e5", "34"), entry("f5", "35"), entry("g5", "36"),
            entry("h5", "37"), entry("a4", "40"), entry("b4", "41"), entry("c4", "42"), entry("d4", "43"),
            entry("e4", "44"), entry("f4", "45"), entry("g4", "46"), entry("h4", "47"), entry("a3", "50"),
            entry("b3", "51"), entry("c3", "52"), entry("d3", "53"), entry("e3", "54"), entry("f3", "55"),
            entry("g3", "56"), entry("h3", "57"), entry("a2", "60"), entry("b2", "61"), entry("c2", "62"),
            entry("d2", "63"), entry("e2", "64"), entry("f2", "65"), entry("g2", "66"), entry("h2", "67"),
            entry("a1", "70"), entry("b1", "71"), entry("c1", "72"), entry("d1", "73"), entry("e1", "74"),
            entry("f1", "75"), entry("g1", "76"), entry("h1", "77"));


    /**
     * converts a position of chess (e.g e4) to the corresponding position in the array (e.g 44)
     * @param position position of chess board (e.g e4)
     * @return equivalent position in the array (e.g 44)
     */
    public String convertGamePositionToArrayPosition(String position) {
        return positions.getValue(position);
    }

    /**
     * returns the corresponding position in a chess board of the position in the array
     * @param position position in the array (e.g 44)
     * @return position in the chess board (e.g e4)
     */
    public String convertArrayPositionToGamePosition(String position) {
        return positions.getKey(position);
    }
}
