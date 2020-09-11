package mvcpatternmainfile.Controller;
import javafx.animation.AnimationTimer;
import mvcpatternmainfile.View.*;
import mvcpatternmainfile.Model.DBmodel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahir
 */
public class MainController extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        UIVIew mview = new UIVIew();
        DBmodel dmod = new DBmodel();
        GameView gobj = new GameView();
        mview.left.setPadding(new Insets(10));
        mview.lwarning.setVisible(false);
        mview.lsuccess.setVisible(false);
        final Scene gscene = new Scene(gobj.createContent());
        mview.ngame.setOnAction(e->{
            primaryStage.setScene(gscene);
            gobj.timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gobj.onUpdate(mview,primaryStage);
            }
        };
            gobj.timer.start();
        });
        mview.lback.setOnAction(e -> primaryStage.setScene(mview.scene));
        mview.signin.setOnAction(
                e->{
                mview.lwarning.setVisible(false);
                mview.lsuccess.setVisible(false);
                    try {
            if(dmod.loginuserdb(mview.namef.getText(),mview.passf.getText(),mview.lsuccess,mview.lwarning)){
                mview.lwarning.setVisible(false);
                mview.lsuccess.setVisible(false);
                dmod.setUserName(mview.namef.getText(),mview.currentuser);
                mview.namef.clear();
                mview.passf.clear();
                primaryStage.setScene(mview.mainpage);
            }
            } catch (Exception ex) {
            }
});
        mview.swarning1.setVisible(false);
        mview.swarning2.setVisible(false);
        mview.swarning3.setVisible(false);
        mview.swarning4.setVisible(false);
        mview.ssuccess.setVisible(false);
        mview.creatacc.setOnAction(e -> {
            mview.swarning1.setVisible(false);
            mview.swarning2.setVisible(false);
            mview.swarning3.setVisible(false);
            mview.swarning4.setVisible(false);
            mview.ssuccess.setVisible(false);
            if(mview.suser.getText().length()==0){
                mview.swarning4.setVisible(true);
            }
                else{
                    mview.swarning4.setVisible(false);
                    int x=dmod.signupmethod(mview.spass.getText(),mview.spass2.getText());
                    if(x==1 || x==4){
                            mview.swarning1.setVisible(true);
                            mview.swarning2.setVisible(false);
                        }
                    else if(x==2){
                        mview.swarning1.setVisible(false);
                        mview.swarning2.setVisible(true);
                    }
                    else{
                        try {
                            mview.swarning1.setVisible(false);
                            mview.swarning2.setVisible(false);
                            dmod.accinsertdb(mview.suser.getText(),mview.spass.getText(),mview.swarning3,mview.ssuccess);
                        } catch (Exception ex) {
                            
                        }
                        
                    }
                }
        });
        mview.signup.setOnAction(e->{primaryStage.setScene(mview.signuppage);
                               mview.lwarning.setVisible(false);
                               mview.lsuccess.setVisible(false);
        });
        mview.back.setOnAction(e->{primaryStage.setScene(mview.scene);
                             mview.swarning1.setVisible(false);
                             mview.swarning2.setVisible(false);
                             mview.swarning3.setVisible(false);
                             mview.swarning4.setVisible(false);
                             mview.ssuccess.setVisible(false);
                             mview.suser.clear();
                             mview.spass.clear();
                             mview.spass2.clear();
        });
        mview.supage.setPadding(new Insets(10));
        mview.forgetpass.setOnAction(e -> {primaryStage.setScene(mview.fpscene);
                                     mview.swarning1.setVisible(false);
                                     mview.swarning2.setVisible(false);
                                     mview.swarning3.setVisible(false);
                                     mview.swarning4.setVisible(false);
                                     mview.ssuccess.setVisible(false);
        });
        mview.fpass.setPadding(new Insets(10));
        mview.fwarning.setVisible(false);
        mview.fwarning1.setVisible(false);
        mview.fwarning2.setVisible(false);
        mview.fwarning3.setVisible(false);
        mview.fsuccess.setVisible(false);
        mview.confirm.setOnAction(e ->{
            mview.fwarning.setVisible(false);
            mview.fwarning1.setVisible(false);           
            mview.fwarning2.setVisible(false);
            mview.fwarning3.setVisible(false);
           mview. fsuccess.setVisible(false);
            try {
                if(dmod.usernameexists(mview.fpassue.getText())){
                    mview.fwarning.setVisible(true);
                }
                else{
                    mview.fwarning.setVisible(false);
                    int x=dmod.signupmethod(mview.fpasspe.getText(),mview.fpasscpe.getText());
                 if(x==1 || x==4){
                    mview.fwarning1.setVisible(false);
                    mview.fwarning2.setVisible(true);
                    mview.fwarning3.setVisible(false);
                    mview.fsuccess.setVisible(false);
                }
                 else if(x==2){
                    mview.fwarning1.setVisible(false);
                    mview.fwarning2.setVisible(false);
                    mview.fwarning3.setVisible(true);
                    mview.fsuccess.setVisible(false);   
                 }
                 else{
            try {   
                    mview.fwarning1.setVisible(false);
                    mview.fwarning2.setVisible(false);
                    mview.fwarning3.setVisible(false);
                    mview.fsuccess.setVisible(false);                    
                    dmod.forgetpassdb(mview.fpassue.getText(),mview.fpasspe.getText(),mview.fwarning1,mview.fsuccess);
                        } 
            catch (Exception ex) {
                            
                        }
                    }
                }
            } catch (Exception ex) {   
            }
        });
        mview.s.getChildren().addAll(mview.swarning1,mview.swarning2,mview.swarning3,mview.ssuccess,mview.swarning4);
        mview.s1.getChildren().addAll(mview.fwarning,mview.fwarning1,mview.fwarning2,mview.fwarning3,mview.fsuccess);
        mview.s2.getChildren().addAll(mview.lwarning,mview.lsuccess);
        mview.goback.setOnAction(e->{primaryStage.setScene(mview.signuppage);
                               mview.fwarning.setVisible(false);
                               mview.fwarning1.setVisible(false);
                               mview.fwarning2.setVisible(false);
                               mview.fwarning3.setVisible(false);
                               mview.fsuccess.setVisible(false);
                               mview.fpassue.clear();
                               mview.fpasspe.clear();
                               mview.fpasscpe.clear();
                                       
        });
        mview.fpass.getChildren().addAll(mview.fpassu,mview.fpassue,mview.fpassp,mview.fpasspe,mview.fpasscp,mview.fpasscpe,mview.s1,mview.confirm,mview.goback);
        mview.supage.getChildren().addAll(mview.luser,mview.suser,mview.lpass,mview.spass,mview.confirmpass,mview.spass2,mview.creatacc,mview.s,mview.back,mview.forgetpass);
        mview.left.getChildren().addAll(mview.usern,mview.namef,mview.userp,mview.passf,mview.signin,mview.s2,mview.newuser,mview.signup);
        mview.gpage.getChildren().addAll(mview.ngame,mview.lback);
        primaryStage.setTitle("ProjectAPP");
        primaryStage.setScene(mview.scene);
        mview.rbutton.setOnAction(e->{
            primaryStage.setScene(mview.mainpage);
        });
        mview.pbox.getChildren().addAll(mview.rbutton);
        gscene.setOnKeyPressed(mscene->{
                if(mscene.getCode()==KeyCode.LEFT){
                    gobj.ally.rotateLeft();
                }
                else if(mscene.getCode()==KeyCode.RIGHT){ 
                    gobj.ally.rotateRight();
                }
                else if(mscene.getCode()==KeyCode.ESCAPE){
                gobj.timer.stop();
                primaryStage.setScene(mview.pscene);
                }
            });
        gobj.ally.getView().setOnMousePressed(e->{gobj.ally.getView().setOnMouseDragged(f->{
            gobj.ally.getView().setTranslateX(f.getSceneX()-20);
            gobj.ally.getView().setTranslateY(f.getSceneY()-10);
        });
        }); 
        primaryStage.setResizable(false);
        primaryStage.show();
    }    

    public void startnewGame(String[] args) {
        launch(args);
    }
}
