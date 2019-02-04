//package hunt;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//import SMA.SMA;
//import core.Agent;
//import core.CaseAgent;
//import core.Environement;
//
//import org.graphstream.algorithm.Dijkstra;
//import org.graphstream.algorithm.Dijkstra.Element;
//import org.graphstream.graph.Graph;
//import org.graphstream.graph.Node;
//import org.graphstream.graph.implementations.SingleGraph;
//
//public class Hunter extends Agent {
//	int pasX, pasY;
//	Graph g;
//	HashMap<String,Node> nodes ;
//	public Hunter(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
//		super(posX, posY, grille, env, sma, born);
//		
////		List<CaseAgent> caseAccesible = new ArrayList<CaseAgent>();
////		nodes = new HashMap<String,Node>();
////		g = new SingleGraph("g");
////
////		for (int i = 0; i < env.getSizeX(); i++) {
////			for (int j = 0; j < env.getSizeY(); j++) {
////				
////				
////				g.addNode(toStr(i, j));
////				
////			}
////
////		}
////		
////		for (int i = 0; i < env.getSizeX(); i++) {
////			for (int j = 0; j < env.getSizeY(); j++) {
////				caseAccesible=env.caseAccesible(i, j);
////				Node n =nodes.get(toStr(i, j));
////				for (CaseAgent ca : caseAccesible) {
////					if(env.getCase(ca)==null)
////						
////						
////						 Dijkstra d = new Dijkstra(Element.EDGE, "weight", "A");
////					g.(toStr(i, j)+toStr(ca.getX(), ca.getY()), toStr(i, j), toStr(ca.getX(), ca.getY()));
////					dijkstra.init(g);
////				}
////				
////			}
////
////		}
//
//	}
//
//	protected String toStr(int i, int j) {
//		return String.valueOf(i) + String.valueOf(j);
//	}
//
//	@Override
//	public void decide() {
//		CaseAgent ca = goTo();
//		move(posX, posY, ca.getX(), ca.getY());		
//	}
//
//	@Override
//	public boolean isDead() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public CaseAgent goTo() {
//		return null;
//		// return good case whit disktra algo;
//	}
//	@Override
//	public void die() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Boolean getBorn() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
