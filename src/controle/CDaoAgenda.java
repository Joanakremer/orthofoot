package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import modelo.MAgenda;
import modelo.MEndereco;

public class CDaoAgenda {
	private CConexao con;
	//Insert -------------------------------------------------------------------------------
		public boolean inserir(MAgenda s) {
	con = CConexao.getInstancia();
			Connection c = con.conectar();
			try {
				String query = "INSERT INTO agenda (idConsulta, data, hora) VALLUES (?, ?);";
				PreparedStatement stm = c.prepareStatement(query);
				
				stm.setInt(1, s.getIdConsulta());
				stm.setDate(4, s.getData());
				stm.setTime(5, s.getHora());
				stm.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
				return false;
			}
		}
		//Update -------------------------------------------------------------------------------
		public boolean update(MAgenda s) {
			con = CConexao.getInstancia();
					Connection c = con.conectar();
					try {
						String query = "UPDATE agenda Set idConsulta = ?, set nomeCompleto = ?, set contato = ?, set data = ?, set hora = ?, set titulo = ? WHERE cep = ?";
						PreparedStatement stm = c.prepareStatement(query);
	
						stm.setInt(1, s.getIdConsulta());
						stm.setDate(4, s.getData());	
						stm.setTime(4, s.getHora());					
						stm.executeUpdate();
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						con.fecharConexao();
						return false;
					}
				}
		//Delete -------------------------------------------------------------------------------
		public boolean delete(MAgenda s) {
			con = CConexao.getInstancia();
					Connection c = con.conectar();
					try {
						String query = "DELETE FROM agenda Where idConsulta = ?"; 
						PreparedStatement stm = c.prepareStatement(query);
						stm.setInt(1, s.getIdConsulta());
						stm.setDate(4, s.getData());	
						stm.setTime(4, s.getHora());						
						stm.executeUpdate();
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						con.fecharConexao();
						return false;
					}
				}
		//List -------------------------------------------------------------------------------
		public ArrayList<MAgenda> listarAgenda() {
		    ArrayList<MAgenda> agenda = new ArrayList<>();
		    
		    con = CConexao.getInstancia();
		    Connection c = con.conectar();
		    
		    try {
		        Statement stm = c.createStatement();
		        String query = "SELECT * FROM agenda";
		        ResultSet rs = stm.executeQuery(query);
		        while (rs.next()) {
		            int idConsulta = rs.getInt("idConsulta");
		            String nomeCompleto = rs.getString("nomeCompleto");
		            String contato = rs.getString("contato");
		            Date data = rs.getDate("data");
		            Time hora = rs.getTime("hora");
		            String titulo = rs.getString("titulo");
		            MAgenda s = new MAgenda();
		            s.setIdConsulta(idConsulta);
		            s.setData(data);
		            s.setHora(hora);
		            agenda.add(s);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }finally {
		    	con.fecharConexao();
		    	return agenda;
			}

		}
}
