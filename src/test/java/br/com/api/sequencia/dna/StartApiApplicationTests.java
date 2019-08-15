package br.com.api.sequencia.dna;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import br.com.api.sequencia.dna.entity.Dna;
import br.com.api.sequencia.dna.repository.DnaRepository;
import br.com.api.sequencia.dna.service.DetectaSequenciaGeneticaService;


/**
 * @author Anderson Nascimento
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class StartApiApplicationTests {

    @InjectMocks
    private DetectaSequenciaGeneticaService detectaSequenciaGeneticaService;
    
    @Mock
    private DnaRepository dnaRepository;


    @Before
    public void setup() {

    }

    @Test
    public void tem_que_ser_um_simio() {

        String[] dna = {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "TCCCCA", "TCACTG"};

        Assert.assertTrue(detectaSequenciaGeneticaService.isSimian(dna));

    }

    @Test
    public void tem_que_ser_um_humano() {

        String[] dna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};

        Assert.assertFalse(detectaSequenciaGeneticaService.isSimian(dna));

    }
    
    @Test
    public void tem_que_ser_um_simio_e_registra() {

        String[] dnas = {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "TCCCCA", "TCACTG"};
        
        Dna dna = new Dna();
        
        dna.setDna(dnas);
        
        Assert.assertTrue(detectaSequenciaGeneticaService.isSimian(dna));

        verify(dnaRepository, times(1)).save(dna);

    }

    @Test
    public void tem_que_ser_um_humano_e_registra() {

        String[] dnas = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        
        Dna dna = new Dna();
        
        dna.setDna(dnas);
        
        Assert.assertFalse(detectaSequenciaGeneticaService.isSimian(dna));

        verify(dnaRepository, times(1)).save(dna);


    }
    
    @Test
    public void executar_estatisticas_retorna_nenhum_registro_encontrado() {

        List<Dna> dnas = new ArrayList<Dna>();
        
        when(dnaRepository.findAll()).thenReturn(dnas);

        Assert.assertTrue(detectaSequenciaGeneticaService.stats().isEmpty());

    }
    
    @Test
    public void executar_estatisticas_retorna_os_registro_encontrado() {

        List<Dna> dnas = new ArrayList<Dna>();
        dnas.add(new Dna());
        
        when(dnaRepository.findAll()).thenReturn(dnas);

        Assert.assertFalse(detectaSequenciaGeneticaService.stats().isEmpty());

    }
}
