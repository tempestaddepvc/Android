package es.iessaladillo.pablorull.ej020_menupopup;

/**
 * Created by Usuario on 06/11/2015.
 */

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdaptadorAlumnos extends ArrayAdapter {
    protected final ArrayList<Alumno> datos;
    public AdaptadorAlumnos(Context contexto, ArrayList<Alumno> datos) {
        super(contexto, R.layout.layout_alumno, datos);
        this.datos = datos;

    }
    protected static class ViewHolder{
        private final TextView txtNombre;
        private final TextView txtEdad;
        private final TextView txtTelefono;
        private final Button btnMenu;
        public ViewHolder(View itemView){
            txtNombre=(TextView) itemView.findViewById(R.id.nombre);
            txtEdad=(TextView) itemView.findViewById(R.id.edad);
            txtTelefono=(TextView)itemView.findViewById(R.id.telefono);
            btnMenu=(Button)itemView.findViewById(R.id.boton);
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
                    .inflate(R.layout.layout_alumno, parent, false);
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
        holder.txtTelefono.setText(datos.get(position).getTelefono());
        holder.btnMenu.setOnClickListener(new OnClickMenuListener(datos.get(position)));



    }

    private class OnClickMenuListener implements View.OnClickListener {
        Alumno alumno;

        public OnClickMenuListener(Alumno alumno) {
            this.alumno = alumno;
        }

        public void onClick(View v) {
            PopupMenu popup = new PopupMenu(getContext(), v);
            // Se infla la especificación de menú.
            MenuInflater inflador = popup.getMenuInflater();
            inflador.inflate(R.menu.popupmenu_layout, popup.getMenu());
            // Se crea el listener para cuando se pulse un ítem del menú, a cuyo
            // constructor se le pasa el mAlumno asociado.
            popup.setOnMenuItemClickListener(new clickEnMenu(
                    alumno));
            // Se muestra el menú.
            popup.show();
        }
    }

    private class clickEnMenu implements PopupMenu.OnMenuItemClickListener {
        Alumno alumno;
        public clickEnMenu(Alumno alumno) {
            this.alumno=alumno;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.llamar:
                    Toast.makeText(getContext(),"Llamando a " + alumno.getNombre(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.mandarMensaje:
                    Toast.makeText(getContext(),"Mandando mensaje a " + alumno.getNombre(), Toast.LENGTH_LONG).show();
                    break;

            }
            return false;
        }
    }
}

