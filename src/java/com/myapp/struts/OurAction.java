/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.*;

/**
 *
 * @author TATARAO
 */
public class OurAction extends DispatchAction {

    /* forward name="success" path="" */
   

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    /*
       
        private Connection getConnection()
        {
            Connection con=null;
            try
            {
                Class.forName("org.gjt.mm.mysql.Driver");
                con=DriverManager.getConnection("jdbc:mysql://loacalhost:3306/rao","root","");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return con;
        }
        
        private void releaseResources(Connection con,PreparedStatement ps)
        {
            if(con!=null)
            {
                try
                {
                con.close();
                }
                catch(Exception e){}
            }
            if(ps!=null)
            {
                try
                {
                    ps.close();
                   
                }
                catch(Exception e){}
            }
        } // release Resources*/
        
        public ActionForward insert(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws SQLException
        {
            Connection con=null;
            PreparedStatement ps=null;
            try
            {
                Class.forName("org.gjt.mm.mysql.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rao","root","");
                DynaActionForm frm=(DynaActionForm)form;
              //  con=this.getConnection();
                ps=con.prepareStatement("insert into struts_disp(id,pass) values(?,?)");
                ps.setString(1, (String)frm.get("id"));
                ps.setString(2,(String)frm.get("pass"));
                
                int i=ps.executeUpdate();
                HttpSession session=request.getSession();
                session.setAttribute("Action", "Inset");
                if(i!=0)
                {
                    return mapping.findForward("success");
                }
                else
                {
                    return mapping.findForward("failure");
                }
            }
            catch(Exception e){
             return mapping.findForward("failure");
            }
         /*   finally
            {
                releaseResources(con,ps);
            } */
        } // Insert
        
        public ActionForward change(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
        {
            Connection con=null;
            PreparedStatement ps=null;
            try
            {
                Class.forName("org.gjt.mm.mysql.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rao","root","");
                DynaActionForm frm=(DynaActionForm)form;
//                con=this.getConnection();
                ps=con.prepareStatement("update struts_disp set pass=? where id=?");
                ps.setString(1, (String)frm.get("pass"));
                ps.setString(2,(String)frm.get("id"));
                
                int i=ps.executeUpdate();
                HttpSession session=request.getSession();
                session.setAttribute("Action", "Update");
                if(i!=0)
                {
                    return mapping.findForward("success");
                }
                else
                {
                    return mapping.findForward("failure");
                }
            }
            catch(Exception e){
             return mapping.findForward("failure");
            }
            finally
            {
   //             releaseResources(con,ps);
            }
        } // Update
        
        public ActionForward delete(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
        {
            Connection con=null;
            PreparedStatement ps=null;
            try
            {
                Class.forName("org.gjt.mm.mysql.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rao","root","");
                DynaActionForm frm=(DynaActionForm)form;
//                con=this.getConnection();
                ps=con.prepareStatement("delete from struts_disp where id=?");
                ps.setString(1, (String)frm.get("id"));
                       
                int i=ps.executeUpdate();
                HttpSession session=request.getSession();
                session.setAttribute("Action", "Delete");
                if(i!=0)
                {
                    return mapping.findForward("success");
                }
                else
                {
                    return mapping.findForward("failure");
                }
            }
            catch(Exception e){
             return mapping.findForward("failure");
            }
            finally
            {
   //             releaseResources(con,ps);
            }
        } //  Delete User
   }
