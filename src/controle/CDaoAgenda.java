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
import modelo.MMedico;
import modelo.MPaciente;

public class CDaoAgenda {
	private CConexao con;
	private static CDaoAgenda instancia;
	
	public static CDaoAgenda getInstancia() {
		if(instancia == null) {
			instancia = new CDaoAgenda();
		}
		return instancia;
	}
	public CDaoAgenda(){		
	}
	
	//Insert -------------------------------------------------------------------------------
		public boolean inserir(MAgenda s) {
	con = CConexao.getInstancia();
		int valida = 0;
			Connection c = con.conectar();
			try {
				String query = "INSERT INTO agendas (data_cons, hora, titulo, nCartao, prontuario, crm) VALUES (?, ?, ?, ?, ?, ?);";
				PreparedStatement stm = c.prepareStatement(query);
				stm.setDate(1, s.getData());
				stm.setTime(2, s.getHora());
				stm.setString(3, s.getTitulo());
				stm.setInt(4, s.getPaciente().getnCarteira());
				stm.setInt(5, s.getPaciente().getProntuario());
				stm.setLong(6, s.getMedico().getCrm());
				
				valida = stm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
			}
			return (valida == 0 ? false : true);
		}
		//Update -------------------------------------------------------------------------------
		public boolean update(MAgenda s) {
			con = CConexao.getInstancia();
					Connection c = con.conectar();
					int valida = 0;
					try {
						String query = "UPDATE agendas Set idConsulta = ?, set nomeCompleto = ?, set contato = ?, set data = ?, set hora = ?, set titulo = ? WHERE cep = ?";
						PreparedStatement stm = c.prepareStatement(query);
	
						stm.setInt(1, s.getIdConsulta());
						stm.setDate(4, s.getData());	
						stm.setTime(4, s.getHora());					
						valida = stm.executeUpdate();						
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						con.fecharConexao();
					}
					return (valida == 0 ? false : true);
				}
		//Delete -------------------------------------------------------------------------------
		public boolean delete(MAgenda s) {
			con = CConexao.getInstancia();
					Connection c = con.conectar();
					int valida = 0;
					try {
						String query = "DELETE FROM agendas Where idConsulta = ?"; 
						PreparedStatement stm = c.prepareStatement(query);
						stm.setInt(1, s.getIdConsulta());					
						valida = stm.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						con.fecharConexao();
					}
					return (valida == 0 ? false : true);
				}
		//List -------------------------------------------------------------------------------
		public ArrayList<MAgenda> listarAgenda() {
		    ArrayList<MAgenda> agendas = new ArrayList<>();
		    
		    con = CConexao.getInstancia();
		    Connection c = con.conectar();
		    
		    try {
		        Statement stm = c.createStatement();
		        String query = "SELECT agendas.*, paciente.* "
		        		+ "FROM orthofoot.agendas "
		        		+ "inner join orthofoot.paciente on paciente.prontuario = agendas.prontuario";
		        ResultSet rs = stm.executeQuery(query);
		        while (rs.next()) {
		            int idConsulta = rs.getInt("idconsulta");
		            String nomeCompleto = rs.getString("nomeCompleto");
		            String contato = rs.getString("contato");
		            Date data = rs.getDate("data_cons");
		            Time hora = rs.getTime("hora");
		            Integer crm = rs.getInt("crm");
		            Integer nCarteira = rs.getInt("nCartao");
		            Integer prontuario = rs.getInt("prontuario");
		            String titulo = rs.getString("titulo");
		            
		            MAgenda s = new MAgenda();
		            s.setIdConsulta(idConsulta);
		            s.setData(data);
		            s.setHora(hora);
		            
		            MPaciente p = new MPaciente();
		            p.setProntuario(prontuario);
		            p.setnomeCompleto(nomeCompleto);
		            p.setnCarteira(nCarteira);
		            p.setConvenio(titulo);		      
		            s.setPaciente(p);
		            
		            MMedico m = new MMedico();
		            m.setCrm(crm);
		            s.setMedico(m);
		            agendas.add(s);
		            
		            
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }finally {
		    	con.fecharConexao();
			}
		    return agendas;

		}
}
