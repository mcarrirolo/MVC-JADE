package controller;

// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import jade.wrapper.StaleProxyException;

/**
 *
 * This class defines the MainController wich is called by the interface through 
 * HTTP protocol
 * 
 * @author Matteo Carrirolo
 * 
 */

// @RestController
// @CrossOrigin(origins = "http://localhost:4200")
@Controller
public class MainController {

    String greeting = "Hello world!";

    @RequestMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    @GetMapping("/quit")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void quit() {
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.quitRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/shutdown")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void shutdown() {
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.shutdownRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public void start(@RequestParam String name, @RequestParam String clas, @RequestParam String args, @RequestParam String owner, @RequestParam String container) {
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
				System.out.println("gam is null");
            }
            else{
                gam.sendNewAgentRequest(name, clas, args, owner, container);
            }
		} catch (StaleProxyException e) {
            e.printStackTrace();
		}
    }

    @GetMapping("/platformName")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String platformName(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return "not working";
            }
            else{
                return gam.platformNameRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "not working";
        }
    }

    @GetMapping("/kill")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void kill(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.killRequest(name);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/suspend")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void suspend(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.suspendRequest(name);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/resume")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void resume(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.resumeRequest(name);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/clone")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void clone(@RequestParam String name, @RequestParam String container, @RequestParam String newname){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.cloneRequest(name, container, newname);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/migrate")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void migrate(@RequestParam String name, @RequestParam String container){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.migrateRequest(name, container);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/freeze")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void freeze(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.freezeRequest(name);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/thaw")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void thaw(@RequestParam String name, @RequestParam String container){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.thawRequest(name, container);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void save(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.saveRequest(name);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/sniffer")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int sniffer(@RequestParam String container){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return -1;
            }
            else{
                return gam.snifferRequest(container);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @GetMapping("/doSniff")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void doSniff(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.doSniffRequest(name);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/doNotSniff")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void doNotSniff(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.doNotSniffRequest(name);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getSniffedMsg")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object[] getSniffedMsg(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.getSniffedMsgRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/dummy")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int dummy(@RequestParam String container){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return -1;
            }
            else{
                return gam.dummyRequest(container);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @GetMapping("/sendDummy")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void sendDummy(@RequestParam String senderName, @RequestParam String receiverName, @RequestParam String commType, @RequestParam String content, @RequestParam String ontology, @RequestParam String language, @RequestParam String protocol, @RequestParam String conversation, @RequestParam String repTo, @RequestParam String repWith, @RequestParam String encoding){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                int commType_ = Integer.parseInt(commType);
                gam.sendDummyRequest(senderName, receiverName, commType_, content, ontology, language, protocol, conversation, repTo, repWith, encoding);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getDummyMsg")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object[] getDummyMsg(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.getDummyMsgRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/log")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int log(@RequestParam String container){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return -1;
            }
            else{
                return gam.logRequest(container);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @GetMapping("/startLog")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object[] startLog(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.startLoggingRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/introspector")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int introspector(@RequestParam String container){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return -1;
            }
            else{
                return gam.introspectorRequest(container);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @GetMapping("/debugOn")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void debugOn(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                System.out.println("\npassing");
                gam.debugOnRequest(name);
                System.out.println("\nDebug on");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/debugOff")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void debugOff(@RequestParam String name){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                System.out.println("\npassing");
                gam.debugOffRequest(name);
                System.out.println("\nDebug off");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getBehaviours")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object[] getBehaviours(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.getBehavioursRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getCurrentState")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getCurrentState(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.getCurrentStateRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getSentMsg")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object[] getSentMsg(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.getSentMsgRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getReceivedMsg")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object[] getReceivedMsg(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.getReceivedMsgRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getPostedMsg")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object[] getPostedMsg(){
        try {
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.getPostedMsgRequest();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/update")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String[] update(){
        try{
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                return gam.updateRequest();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/addPlatformAMS")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void addPlatformAMS(@RequestParam String url){
        try{
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.addPlatformAMSRequest(url);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/refreshAgents")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public void refreshAgents(@RequestParam String platform){
        try{
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
            }
            else{
                gam.refreshAgentsRequest(platform);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/getAPDescription")
    // @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getAPDescription(){
        try{
            IGAM gam = Launcher.gamCtrl.getO2AInterface(IGAM.class);
            if (gam == null) {
                System.out.println("gam is null");
                return null;
            }
            else{
                System.out.println("\nPassing at the request...");
                return gam.getAPDescriptionRequest();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}