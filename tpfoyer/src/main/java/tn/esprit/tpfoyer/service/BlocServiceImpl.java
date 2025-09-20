package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;
@Service
public class BlocServiceImpl implements IBlocService {
    @Autowired
    public BlocRepository blocRepository;

    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc createBlocAndFoyer(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void assignBlocToFoyer(Long blocId, Long foyerId) {
      Bloc bloc = blocRepository.findById(blocId).get();
      Foyer foyer = foyerRepository.findById(foyerId).get();
      bloc.setFoyer(foyer);
      blocRepository.save(bloc);
    }

    @Override
    public void desaffecterBlocDeFoyer(Long blocId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        bloc.setFoyer(null);
        blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> findAllBlocWithoutFoyer() {
        return blocRepository.findAllByFoyerIsNull();
    }

}
