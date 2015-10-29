package es.iessaladillo.pablorull.ej019_arrayadapterpersonalizado;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Usuario on 29/10/2015.
 */
public class AdaptadorAlumnos extends ArrayAdapter {
    protected final ArrayList<Alumno> datos;
    public AdaptadorAlumnos(Context contexto, ArrayList<Alumno> datos) {
        super(contexto, R.layout.alumnos_layout, datos);
        this.datos = datos;

    }
    protected static class ViewHolder{
        private final TextView txtNombre;
        private final TextView txtEdad;
        public ViewHolder(View itemView){
            txtNombre=(TextView) itemView.findViewById(R.id.nombre);
            txtEdad=(TextView) itemView.findViewById(R.id.edad);
        }

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Contenedor de las vistas que conforman la vista-fila.
        ViewHolder holder;
        // Si no hay vista-fila para reciclar, se infla el layut.
        if (convertView == null) {
            // Se obtiene un inflador de vista que se usa para inflar la
            // especificación XML del layout, obteniendo como resultado la vista
            // que representa el layout completa a usar para dibujar el elemento.
            // El método inflate debe recibir la vista padre (parent), de la que se
            // hará colgar la vista inflada, para que se creen correctamente sus
            // LayoutParams. El último parámetro indica si la vista inflada debe
            // colgar directamente de la raíz del layout en el que se incluye.
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.alumnos_layout, parent, false);
            // Se crea un nuevo objeto contenedor de las vistas de la vista-fila.
            holder = new ViewHolder(convertView);
            // Se almacena el contenedor en la propiedad Tag de la vista-fila.
            convertView.setTag(holder);
        }
        // Si la vista-fila corresponde a un objeto reciclable.
        else {
            // Se obtienen el objeto contenedor desde la propiedad Tag de la vista-fila.
            holder = (ViewHolder) convertView.getTag();
        }
        // Se "escriben" los datos en dichas vistas. Para obtener el dato
        // concreto se utiliza el parámetro position que actúa como índice del
        // array de datos gestionados por el adaptador.
        onBindViewHolder(holder, position);
        // Se retorna la vista-fila.
        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtNombre.setText(datos.get(position).getNombre());
        int edad=datos.get(position).getEdad();


        if (edad<18) {
            holder.txtEdad.setTextColor((Color.rgb(200,0,0)));
            holder.txtEdad.setText(edad +"");
        }
        else {
            holder.txtEdad.setTextColor((Color.rgb(0,0,0)));
            holder.txtEdad.setText(edad +"");
        }

    }

}
