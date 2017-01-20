package ListasEncadenadasDobles;

import ListasEncadenadasDobles.NodoD;

public class ListasDobleEnlace {

	protected NodoD cabezaLista; //nodo inicial de la lista (cabeza)
	protected NodoD finalLista; //nodo inicial de la lista (cabeza)
	protected int tama�o; 	// n�mero de nodos en la lista 

	public void ListaDobleEnlace(){ //Constructor por defecto, crea lista vac�a 
		cabezaLista = new NodoD("head", null, finalLista); 
		tama�o = 0; 
	}

	public int getTama�o(){
		return tama�o;
	}

	public boolean verificarVacia(){

		return getTama�o()==0;
	}

	public void agregarNodoInicio(NodoD nodoNuevo){ 


		NodoD nodoAux=cabezaLista.getSiguiente(); //copia de la lista

		nodoNuevo.setSiguiente(nodoAux); // nodo ingresado se conecta con el 
		nodoNuevo.setAnterior(cabezaLista);

		nodoAux.setAnterior(nodoNuevo);

		cabezaLista.setSiguiente(nodoNuevo);

		tama�o++; // El tama�o de la lista aumenta en 1 

	}

	public void agregarNodoFinal(NodoD nodoNuevo){ 

		NodoD nodoAux = finalLista.getAnterior();

		nodoNuevo.setAnterior(nodoAux);
		nodoNuevo.setSiguiente(finalLista); 

		nodoAux.setSiguiente(nodoNuevo);

		finalLista.setAnterior(nodoNuevo);

		tama�o++;
	}

	public void agregarNuevoNodoAntes(NodoD nodoNuevo, String dato){ 

		NodoD nodoAux = null;
		NodoD nodoAuxAnt = null;
			
	/*	if (verificarVacia()==true) {

			cabezaLista.setSiguiente(nodoNuevo);
			finalLista.setAnterior(nodoNuevo);

		} 
*/
		nodoAux=buscarNodoContenido(dato);

		if(nodoAux != null){
			
			nodoAuxAnt = nodoAux.getAnterior();
			
			nodoNuevo.setAnterior(nodoAuxAnt);
			nodoNuevo.setSiguiente(nodoAux);
			
			nodoAuxAnt.setSiguiente(nodoNuevo);
			
			nodoAux.setAnterior(nodoNuevo);
		}

		tama�o++;
	}
	
	public void agregarNuevoNodoDespues(NodoD nodoNuevo, String dato){ 

		NodoD nodoAux = null;
		NodoD nodoAuxSig = null;
			
	/*	if (verificarVacia()==true) {

			cabezaLista.setSiguiente(nodoNuevo);
			finalLista.setAnterior(nodoNuevo);

		} 
*/
		nodoAux=buscarNodoContenido(dato);

		if(nodoAux != null){
			
			nodoAuxSig = nodoAux.getSiguiente();
			
			nodoNuevo.setSiguiente(nodoAuxSig);
			nodoNuevo.setAnterior(nodoAux);
			
			nodoAuxSig.setAnterior(nodoNuevo);
			
			nodoAux.setSiguiente(nodoNuevo);
		}

		tama�o++;
	}

	public void agregarNuevoNodoPosicion(NodoD nodoNuevo, int posicion){ 

		NodoD nodoAuxAnt = null;
		NodoD nodoAuxSig = null;
			
		nodoAuxAnt=buscarNodoPosicion(posicion);

		if(nodoAuxAnt != null){
			
			nodoAuxSig = nodoAuxAnt.getSiguiente();
			
			nodoNuevo.setSiguiente(nodoAuxSig);
			nodoNuevo.setAnterior(nodoAuxAnt);
			
			nodoAuxSig.setAnterior(nodoNuevo);
			
			nodoAuxAnt.setSiguiente(nodoNuevo);
		}

		tama�o++;
	}
	
	public void eliminarIncio(){

		NodoD nodoAux = cabezaLista.getSiguiente();

		cabezaLista.setSiguiente(nodoAux.getSiguiente());
		nodoAux.getSiguiente().setAnterior(cabezaLista);

		tama�o--;

	}

	public void eliminarFinal(){

		NodoD nodoAux = finalLista.getAnterior();//copia de la lista

		finalLista.setAnterior(nodoAux.getAnterior());
		nodoAux.getAnterior().setSiguiente(finalLista);

		tama�o--;

	}

	public NodoD buscarNodoContenido(String dato){

		NodoD nodoAux=cabezaLista.getSiguiente(); 
		NodoD nodoEncontrado=null;

		while(nodoAux!=null){  

			if(dato.equals(nodoAux.getElemento())){ 

				nodoEncontrado=nodoAux;

			}else{

				nodoAux=nodoAux.getSiguiente();
			}
		}

		return nodoEncontrado;
	}

	public int obtenerPosicion(String dato){

		NodoD nodoAux=cabezaLista.getSiguiente(); 
		int indice=0;

		while(nodoAux!=null){  

			if(dato.equals(nodoAux.getElemento())){ 

				return indice;

			}else{

				indice++;
			}
		}

		return indice;
	}

	public NodoD buscarNodoPosicion(int posicion){

		NodoD nodoAux=cabezaLista.getSiguiente(); 
		NodoD nodoEncontrado=null;
		int i=0;

		if( posicion>tama�o || posicion <tama�o){

			nodoEncontrado=null;

		}else{

			do{

				nodoAux=nodoAux.getSiguiente();
				i++;

				if(i==posicion)
					nodoEncontrado=nodoAux;

			}while(posicion<tama�o);
		}

		return nodoEncontrado;
	}

	public void eliminarLista(){

		cabezaLista.setSiguiente(finalLista);
		finalLista.setAnterior(cabezaLista);
		tama�o=0;

	}

	public void editarNodoContenido(String dato, String datoNuevo){

		NodoD nodoAux = null;

		nodoAux=buscarNodoContenido(dato);

		if(nodoAux!=null){

			nodoAux.setElemento(datoNuevo);

		}

	}

	public void editarNodoPosici�n(int posicion, String dato){

		NodoD nodoAux = null;

		nodoAux=buscarNodoPosicion(posicion);

		if(nodoAux!=null){

			nodoAux.setElemento(dato);

		}

	}

	public void eliminarNodoContenido(String dato){

		NodoD nodoAux = null;
		NodoD nodoAux2=null;
		NodoD nodoAux3=null;

		nodoAux=buscarNodoContenido(dato);

		if(nodoAux!=null){

			nodoAux2=nodoAux.getAnterior();
			nodoAux3=nodoAux.getSiguiente();

			nodoAux2.setSiguiente(nodoAux3);

			nodoAux3.setAnterior(nodoAux2);

		}

	}

	public void eliminarNodoPosici�n(int posicion){

		NodoD nodoAux = null;
		NodoD nodoAux2=null;
		NodoD nodoAux3=null;

		nodoAux=buscarNodoPosicion(posicion);

		if(nodoAux!=null){

			nodoAux2=nodoAux.getAnterior();
			nodoAux3=nodoAux.getSiguiente();

			nodoAux2.setSiguiente(nodoAux3);

			nodoAux3.setAnterior(nodoAux2);

		}

	}

	public String recorrerListaAscendente(){

		String lista = "";

		if(verificarVacia()==false){

			NodoD nodoAux= cabezaLista.getSiguiente();
			int i=0;

			while(nodoAux.getElemento()!= null){

				lista += (i + ". [ "+ nodoAux.getElemento()+" ] -> ");
				nodoAux=nodoAux.getSiguiente();

				i++;
			}

		}
		return lista;

	}

	public String recorrerListaDescendente(){

		String lista = "";

		if(verificarVacia()==false){

			NodoD nodoAux= finalLista.getAnterior();
			int i=tama�o;

			while(nodoAux.getElemento()!= null){

				lista += (i + ". [ "+ nodoAux.getElemento()+" ] <- ");
				nodoAux=nodoAux.getAnterior();

				i--;
			}

		}
		return lista;

	}

}
