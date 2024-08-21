import br.com.controle.Canil;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ManterCanil extends DAO{
    
    public void cadastrar_cão(Canil c) throws Exception {
        try{
        abrirBanco();
        String query = "INSERT INTO novo_cão (nome, raça, porte, origem, gênero, idade)"
                + "values (?,?,?,?,?,?)";
        pst=(PreparedStatement) con.prepareStatement(query);
        pst.setString(1, c.getNome());
        pst.setString(2, c.getRaça());
        pst.setString(3, c.getPorte());
        pst.setString(4, c.getOrigem());
        pst.setString(5, c.getGênero());
        pst.setString(6, c.getIdade());
        pst.execute();
        fecharBanco();
            
        }
        catch (Exception e) {
        System.out.println("Erro " + e.getMessage());
        }  
    }
    
    public void atualizar_triagem(Canil c) throws Exception {
        try{
        abrirBanco();
        String query = "UPDATE Triagem SET nome = ?, peso = ?, Vermifugação = ?, Antirrábica = ?,"
                + " Leishmaniose = ?, V8 = ?, Gripe_Canina = ?, Giárdia=?, data_admissão = curdate(),Revacinacao = ? where ID=?";
        
         pst=(PreparedStatement) con.prepareStatement(query);
         pst.setString(1, c.getNome());
         pst.setString(2, c.getPeso());
         pst.setString(3, c.getVermifugação());
         pst.setString(4, c.getAntirrábica());
         pst.setString(5, c.getLeishmaniose());
         pst.setString(6, c.getV8());
         pst.setString(7, c.getGripe_Canina());
         pst.setString(8, c.getGiárdia());
         pst.setString(9, c.getRevacinacao());
         pst.setInt(10, c.getID());
         pst.execute();
         pst.executeUpdate();
         fecharBanco();
        } catch(Exception e) {
        System.out.println("Erro " + e.getMessage());
        }            
}
    
    
    
    public void inserir_clientes (Canil c) throws Exception {
    try{
    abrirBanco();
    String query = "insert into Clientes (Nome, Telefone, Endereço)"+"values (?,?,?)";
    pst=(PreparedStatement) con.prepareStatement(query);
    pst.setString(1, c.getNome());
    pst.setString(2, c.getTelefone());
    pst.setString(3, c.getEndereço());
    pst.execute();
    }
    catch(Exception e){
    System.out.println("Erro " + e.getMessage());
    }
    
    }
    
   public ArrayList<Canil> ListarTriagem () throws Exception {
       ArrayList<Canil> canis = new ArrayList<Canil>();
         try{
         abrirBanco();  
         String query = "select * FROM Triagem";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         Canil c ;
         while (tr.next()){               
           c = new Canil();
           c.setID(tr.getInt("ID"));
           c.setNome(tr.getString("Nome"));
           c.setRaça(tr.getString("Raça"));
           c.setPeso(tr.getString("Peso"));
           c.setPorte(tr.getString("Porte"));
           c.setOrigem(tr.getString("Origem"));
           c.setGênero(tr.getString("Gênero"));
           c.setIdade(tr.getString("Idade"));
           c.setVermifugação(tr.getString("Vermifugação"));
           c.setAntirrábica(tr.getString("Antirrábica"));
           c.setV8(tr.getString("V8"));
           c.setGripe_Canina(tr.getString("Gripe_Canina"));
           c.setLeishmaniose(tr.getString("leishmaniose"));
           c.setGiárdia(tr.getString("Giárdia"));
           c.setData_admissão(tr.getString("Data_admissão"));
           c.setRevacinacao(tr.getString("Revacinacao"));
           canis.add(c);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return canis;
     }
    
      public ArrayList<Canil> ListarClientes () throws Exception {
       ArrayList<Canil> canis = new ArrayList<Canil>();
         try{
         abrirBanco();  
         String query = "select * FROM Clientes";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         Canil c ;
         while (tr.next()){               
           c = new Canil();
           c.setID(tr.getInt("ID"));
           c.setNome(tr.getString("Nome"));
           c.setTelefone(tr.getString("Telefone"));
           c.setEndereço(tr.getString("Endereço"));
           canis.add(c);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return canis;
     } 
   
    public ArrayList<Canil> Listar_Todos_Cães () throws Exception {
       ArrayList<Canil> canis = new ArrayList<Canil>();
         try{
         abrirBanco();  
         String query = "select ID, Nome, Raça, Peso, Porte, Origem, Gênero, Idade, data_admissão, Revacinacao FROM cães_raça UNION ALL"
                 + " select ID, Nome, Raça, Peso, Porte, Origem, Gênero, Idade, data_admissão, Revacinacao FROM cães_viralata";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         Canil c ;
         while (tr.next()){               
           c = new Canil();
           c.setID(tr.getInt("ID"));
           c.setNome(tr.getString("Nome"));
           c.setRaça(tr.getString("Raça"));
           c.setPeso(tr.getString("Peso"));
           c.setPorte(tr.getString("Porte"));
           c.setOrigem(tr.getString("Origem"));
           c.setGênero(tr.getString("Gênero"));
           c.setIdade(tr.getString("Idade"));
           c.setData_admissão(tr.getString("data_admissão"));
           c.setRevacinacao(tr.getString("Revacinacao"));
           canis.add(c);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return canis;
     }
    
    
    
    public ArrayList<Canil> Listar_viralatas () throws Exception {
       ArrayList<Canil> canis = new ArrayList<Canil>();
         try{
         abrirBanco(); 
         String query = "select ID, Nome, Raça, Peso, Porte, Origem, Gênero, Idade, data_admissão, Revacinacao FROM cães_viralata";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
            if (pst == null) {
            System.out.println("PreparedStatement is null");
            return canis;
        }
         Canil c ;
         while (tr.next()){               
           c = new Canil();
           c.setID(tr.getInt("ID"));
           c.setNome(tr.getString("Nome"));
           c.setRaça(tr.getString("Raça"));
           c.setPeso(tr.getString("Peso"));
           c.setPorte(tr.getString("Porte"));
           c.setOrigem(tr.getString("Origem"));
           c.setGênero(tr.getString("Gênero"));
           c.setIdade(tr.getString("Idade"));
           c.setData_admissão(tr.getString("data_admissão"));
           c.setRevacinacao(tr.getString("Revacinacao"));
           canis.add(c);
         } 
         fecharBanco();
       }catch (Exception e){
           e.printStackTrace();
     } 
       return canis;
     }
    
    
    public ArrayList<Canil> Listar_raça () throws Exception {
       ArrayList<Canil> canis = new ArrayList<Canil>();
         try{
         abrirBanco(); 
         String query = "select ID, Nome, Raça, Peso, Porte, Origem, Gênero, Idade, data_admissão, Revacinacao FROM cães_raça";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
            if (pst == null) {
            System.out.println("PreparedStatement is null");
            return canis;
        }
         Canil c ;
         while (tr.next()){               
           c = new Canil();
           c.setID(tr.getInt("ID"));
           c.setNome(tr.getString("Nome"));
           c.setRaça(tr.getString("Raça"));
           c.setPeso(tr.getString("Peso"));
           c.setPorte(tr.getString("Porte"));
           c.setOrigem(tr.getString("Origem"));
           c.setGênero(tr.getString("Gênero"));
           c.setIdade(tr.getString("Idade"));
           c.setData_admissão(tr.getString("data_admissão"));
           c.setRevacinacao(tr.getString("Revacinacao"));
           canis.add(c);
         } 
         fecharBanco();
       }catch (Exception e){
           e.printStackTrace();
     } 
       return canis;
     }

    
      public ArrayList<Canil> ListarVendas () throws Exception {
       ArrayList<Canil> canis = new ArrayList<Canil>();
         try{
         abrirBanco();  
         String query = "select ID, Cliente_id, Cão_id, Valor, Data_venda FROM Vendas";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         Canil c ;
         while (tr.next()){               
           c = new Canil();
           c.setID(tr.getInt("ID"));
           c.setCliente_id(tr.getInt("Cliente_id"));
           c.setCão_id(tr.getInt("Cão_id"));
           c.setValor(tr.getString("Valor"));
           c.setData_venda(tr.getString("Data_venda"));
           canis.add(c);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return canis;
     }

 
public ArrayList<Canil> ListarAdotados () throws Exception {
       ArrayList<Canil> canis = new ArrayList<Canil>();
         try{
         abrirBanco();  
         String query = "select * FROM Doações";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         Canil c ;
         while (tr.next()){               
           c = new Canil();
           c.setID(tr.getInt("ID"));
           c.setCliente_id(tr.getInt("Cliente_id"));
           c.setCão_id(tr.getInt("Cão_id"));
           c.setData_doação(tr.getString("Data_doação"));
           canis.add(c);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return canis;
     }

 public void inserir_venda (Canil c) throws Exception {
    try{
    abrirBanco();
    String query = "insert into Vendas (Cliente_id, Cão_id, Valor, data_venda)"+"values (?,?,?, curdate())";
    pst=(PreparedStatement) con.prepareStatement(query);
    pst.setInt(1, c.getCliente_id());
    pst.setInt(2, c.getCão_id());
    pst.setString(3, c.getValor());
    pst.execute();
    }
    catch(Exception e){
    System.out.println("Erro " + e.getMessage());
    }
    
    }
 
 public void inserir_doação (Canil c) throws Exception {
    try{
    abrirBanco();
    String query = "insert into Doações (Cliente_id, Cão_id, data_doação)"+"values (?,?, curdate())";
    pst=(PreparedStatement) con.prepareStatement(query);
    pst.setInt(1, c.getCliente_id());
    pst.setInt(2, c.getCão_id());
    pst.execute();
    }
    catch(Exception e){
    System.out.println("Erro " + e.getMessage());
         }
 
      }
 

}


    

