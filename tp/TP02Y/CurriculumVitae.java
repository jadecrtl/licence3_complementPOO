public class CurriculumVitae {
    final Diplome.Bac bac;
    final Diplome.DAEU daeu;
    final Diplome.Licence licence;
    final Diplome.Master master;
    final Diplome.DiplomeInge dInge;
    final Diplome.Doctorat doctorat;

    public CurriculumVitae(CVBuilder cvBuilder){
        if((cvBuilder.bac == null && cvBuilder.daeu == null && (cvBuilder.licence != null || cvBuilder.dInge != null)) || 
        (cvBuilder.licence == null && cvBuilder.dInge == null && cvBuilder.master != null) || 
        (cvBuilder.doctorat != null && cvBuilder.master == null)) throw new IllegalArgumentException();
        bac = cvBuilder.bac;
        daeu = cvBuilder.daeu;
        licence = cvBuilder.licence;
        master = cvBuilder.master;
        dInge = cvBuilder.dInge;
        doctorat = cvBuilder.doctorat;
    }
}
