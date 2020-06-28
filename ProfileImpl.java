import java.sql.*;

import java.util.*;



/**

 *

 * @author windows

 */

public abstract class ProfileImpl implements ProfileServices {



    @Override

    public Profil insert(Profil final) throws SQLException {

        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("insert into final values(?,?,?,?,?)");

        st.setString(1, final.getId());

        st.setString(2, final.getNama());

        st.setString(3, final.getJk());

        st.setString(4, final.getAlamat());

        st.setString(5, final.getEmail());

        st.executeUpdate();







        return final;

    }



    @Override

    public void update(Profil final) throws SQLException {

        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("update final set nama=?,alamat=?,jk=?,email=? where nomhs=?");



        st.setString(1, final.getNama());

        st.setString(3, final.getAlamat());

        st.setString(4, final.getJk());

        st.setString(5, final.getEmail());

        st.setString(3, final.getId());

        st.executeUpdate();



    }

    

    public void delete(int id) throws SQLException {

        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("delete from final where id=?");

        st.setInt(1, id);

        st.executeUpdate();

    }



    @Override

    public List getAll() throws SQLException {

        Statement st = KoneksiDb.getConnection().createStatement();

        ResultSet rs = st.executeQuery("select * from final");

        List list = new ArrayList();

        while (rs.next()) {

            Profil p = new Profil();

            p.setId(rs.getString("id"));

            p.setNama(rs.getString("nama"));

            p.setJk(rs.getString("jk"));

            p.setAlamat(rs.getString("alamat"));

            p.setEmail(rs.getString("email"));

            list.add(p);

        }

        return list;

    }

}