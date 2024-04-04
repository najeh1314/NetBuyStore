import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionStockSQLite {

    private static final String URL = "jdbc:sqlite:stock.db";

    public static void main(String[] args) {
        try {
            // Charger la classe du pilote JDBC SQLite
            Class.forName("org.sqlite.JDBC");

            // Reste du code...
            createTable();
            Produit produit = new Produit("Ordinateur Portable", 899.99, 10);
            saveProduit(produit);
            Produit produitCherche = findProduit("Ordinateur Portable");
            if (produitCherche != null) {
                System.out.println("Produit trouvé : " + produitCherche);
            } else {
                System.out.println("Produit non trouvé.");
            }
        } catch (ClassNotFoundException e) {
            // Gérer l'exception ClassNotFoundException
            e.printStackTrace();
        }
    }

    private static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS produits (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nom TEXT NOT NULL," +
                "prix REAL NOT NULL," +
                "quantite INTEGER NOT NULL)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void saveProduit(Produit produit) {
        String insertSQL = "INSERT INTO produits (nom, prix, quantite) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, produit.getNom());
            preparedStatement.setDouble(2, produit.getPrix());
            preparedStatement.setInt(3, produit.getQuantite());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Produit findProduit(String nomProduit) {
        String selectSQL = "SELECT * FROM produits WHERE nom = ?";
        Produit produit = null;

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, nomProduit);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                produit = new Produit(
                        resultSet.getString("nom"),
                        resultSet.getDouble("prix"),
                        resultSet.getInt("quantite")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
    }
}
