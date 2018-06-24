package merhabadunya.com.progressbarkullanimi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by omera on 12.03.2018.
 */

    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private List<user> kullaniciListe;

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                user movie = kullaniciListe.get(position);
                holder.title.setText(movie.getTitle());
                holder.genre.setText(movie.getGenre());
                holder.year.setText(movie.getYear());

            }

            @Override
            public int getItemCount() {
                return kullaniciListe.size();
            }

            public class MyViewHolder extends RecyclerView.ViewHolder {
                public TextView title, year, genre;
                public MyViewHolder(View itemView) {

                    super(itemView);
                    title = (TextView) itemView.findViewById(R.id.title);
                    genre = (TextView) itemView.findViewById(R.id.genre);
                    year = (TextView) itemView  .findViewById(R.id.year);
                }
            }
    public UserAdapter(List<user> kullaniciListe) {
        this.kullaniciListe = kullaniciListe;
    }
}
